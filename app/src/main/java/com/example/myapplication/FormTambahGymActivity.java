package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;

public class FormTambahGymActivity extends AppCompatActivity {

    DatabaseReference database; // untuk mengambil root pada database

    Button ch,ch2;
    ImageView img2;

    EditText etNamaGym, etAlamatGym, etNomorHP; // Detail GYM
    EditText etPendaftar, etInsidental, etBiaya1, etBiaya2, etBiaya3, etBiaya6, etPerpanjangan; // Paket Membership
    EditText etTemu5, etTemu10, etTemu15, etTemu20; // Biaya Personal Trainer
    EditText etFasilitas, etKelas, etPeralatan, etKeunggulan,etNamaTrainerGym;


    Button btUpload,btSubmitDB,btUploadMesin;
    ImageView img;
    StorageReference mStorageReference,mStorageReference2;
    public Uri imguri,imguri2;
    public String temp1=null,temp2=null;
    private StorageTask uploadTask,uploadTask2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_tambah_gym);

        mStorageReference = FirebaseStorage.getInstance().getReference("DATA GYM");
        mStorageReference2 = FirebaseStorage.getInstance().getReference("DATA GYM TRAINER");

        ch=(Button)findViewById(R.id.buttonChoose);
        img=(ImageView)findViewById(R.id.imageView);
        ch2=(Button)findViewById(R.id.buttonChoose2);
        img2=(ImageView)findViewById(R.id.imageView2);

        ch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Filechoser();
            }
        }
        );

        ch2.setOnClickListener(new View.OnClickListener(){
                                  @Override
                                  public void onClick(View view){
                                      Filechoser2();
                                  }
                              }
        );

        //inisialisasi Detail GYM
        etNamaGym       = (EditText) findViewById(R.id.edt_NamaGym);
        etAlamatGym     = (EditText) findViewById(R.id.edt_Alamat);
        etNomorHP       = (EditText) findViewById(R.id.edt_NoTelp);

        //inisialisasi Paket Membership
        etPendaftar     = (EditText) findViewById(R.id.edt_pktPendaftaran);
        etInsidental    = (EditText) findViewById(R.id.edt_pktInsidental);
        etBiaya1        = (EditText) findViewById(R.id.edt_pktSatubln);
        etBiaya2        = (EditText) findViewById(R.id.edt_pktDuabln);
        etBiaya3        = (EditText) findViewById(R.id.edt_pktTigabln);
        etBiaya6        = (EditText) findViewById(R.id.edt_pktEnambln);
        etPerpanjangan  = (EditText) findViewById(R.id.edt_pktPerpanjangan);

        //inisialisasi Biaya Personal Trainer
        etTemu5         = (EditText) findViewById(R.id.edt_byLimaPert);
        etTemu10        = (EditText) findViewById(R.id.edt_bySepulPert);
        etTemu15        = (EditText) findViewById(R.id.edt_byLimabelsPert);
        etTemu20        = (EditText) findViewById(R.id.edt_byDuapulPert);
        etNamaTrainerGym =  (EditText) findViewById(R.id.edtNamaTrainerGym);

        etKeunggulan    = (EditText) findViewById(R.id.edt_Keunggulan);

        //inisialisasi Button Submit dan Upload
        btSubmitDB      = (Button) findViewById(R.id.btn_submit);

        // Inisialisasi Fireb,ase
        database = FirebaseDatabase.getInstance().getReference();

        //Onclick pada Button Submit
//        btSubmitDB.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                submitData(new Data(
//                        etNamaGym.getText().toString(),
//                        etAlamatGym.getText().toString(),
//                        etNomorHP.getText().toString(),
//                        etPendaftar.getText().toString(),
//                        etInsidental.getText().toString(),
//                        etBiaya1.getText().toString(),
//                        etBiaya2.getText().toString(),
//                        etBiaya3.getText().toString(),
//                        etBiaya6.getText().toString(),
//                        etPerpanjangan.getText().toString(),
//                        etTemu5.getText().toString(),
//                        etTemu10.getText().toString(),
//                        etTemu15.getText().toString(),
//                        etTemu20.getText().toString(),
//                        imguri.toString()));
//            }
//        });

        btSubmitDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(uploadTask!=null && uploadTask.isInProgress() && uploadTask2!=null && uploadTask2.isInProgress()){
                    Toast.makeText(FormTambahGymActivity.this, "upload in progress",Toast.LENGTH_LONG).show();
                }else{
                    FileUploader();
                }
            }
        });

    }
    private String getExtension(Uri uri){
        ContentResolver cr=getContentResolver();
        MimeTypeMap mimeTypeMap=MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(cr.getType(uri));
    }


    private void FileUploader(){

        final StorageReference ref=mStorageReference.child(System.currentTimeMillis()+"."+getExtension(imguri));
        uploadTask= ref.putFile(imguri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        // Get a URL to the uploaded content
                        Toast.makeText(FormTambahGymActivity.this, "image uploaded succesfully",Toast.LENGTH_LONG).show();
                        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                    temp1=uri.toString();
                            }
                        });
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle unsuccessful uploads
                        // ...
                    }
                });
        final StorageReference ref2=mStorageReference2.child(System.currentTimeMillis()+"."+getExtension(imguri2));
        uploadTask2= ref2.putFile(imguri2)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        // Get a URL to the uploaded content
                        Toast.makeText(FormTambahGymActivity.this, "image uploaded succesfully",Toast.LENGTH_LONG).show();
                        ref2.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                temp2=uri.toString();
                                submitData(new Data(
                                        etNamaGym.getText().toString(),
                                        etAlamatGym.getText().toString(),
                                        etNomorHP.getText().toString(),
                                        etPendaftar.getText().toString(),
                                        etInsidental.getText().toString(),
                                        etBiaya1.getText().toString(),
                                        etBiaya2.getText().toString(),
                                        etBiaya3.getText().toString(),
                                        etBiaya6.getText().toString(),
                                        etPerpanjangan.getText().toString(),
                                        etTemu5.getText().toString(),
                                        etTemu10.getText().toString(),
                                        etTemu15.getText().toString(),
                                        etTemu20.getText().toString(),
                                        etNamaTrainerGym.getText().toString(),
                                        temp1,
                                        temp2));
                            }
                        });
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle unsuccessful uploads
                        // ...
                    }
                });
    }


    private void Filechoser(){
        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityIfNeeded(intent, 1);
    }
    private void Filechoser2(){
        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityIfNeeded(intent, 2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && resultCode==RESULT_OK && data!=null && data.getData()!=null){
            imguri=data.getData();
            img.setImageURI(imguri);
        }
        if(requestCode==2 && resultCode==RESULT_OK && data!=null && data.getData()!=null){
            imguri2=data.getData();
            img2.setImageURI(imguri2);

        }
    }

    public void MasukData(){

    }


    public void submitData (Data data){
        database.child("Detail-GYM").push().setValue(data).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {

                // set data Detail gym
                etNamaGym.setText("");
                etAlamatGym.setText("");
                etNomorHP.setText("");

                //set data paket membership
                etPendaftar.setText("");
                etInsidental.setText("");
                etBiaya1.setText("");
                etBiaya2.setText("");
                etBiaya3.setText("");
                etBiaya6.setText("");
                etPerpanjangan.setText("");

                //set data biaya personal trainer
                etTemu5.setText("");
                etTemu10.setText("");
                etTemu15.setText("");
                etTemu20.setText("");

                //etFasilitas.setText("");
//                etKelas.setText("");
  //              etPeralatan.setText("");
    //            etKeunggulan.setText("");



                Snackbar.make(findViewById(R.id.btn_submit),"Data Berhasil Ditambahkan", Snackbar.LENGTH_LONG).show();
            }
        });


//        database.child("Paket-Membership").push().setValue(data).addOnSuccessListener(this, new OnSuccessListener<Void>() {
//            @Override
//            public void onSuccess(Void aVoid) {
//
//            }
//        });
//        database.child("Biaya Personal Trainer").push().setValue(data).addOnSuccessListener(this, new OnSuccessListener<Void>() {
//            @Override
//            public void onSuccess(Void aVoid) {
//
//            }
//        });
    }

    public static Intent getActIntent(Activity activity){
        return new Intent(activity, FormTambahGymActivity.class);
    }


}
