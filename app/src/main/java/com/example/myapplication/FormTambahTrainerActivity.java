package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;

public class FormTambahTrainerActivity extends AppCompatActivity {

    Button ch,up;
    ImageView img;
    StorageReference mStorageReference;
    public Uri imguri;
    private StorageTask uploadTask;

    DatabaseReference database; // untuk mengambil root pada database

    EditText etNamaTrainer, etPendidikan, etGym,
            etOn, etTelepon, etSosmed,etPengalaman, etTarif,
            etSertifikasi, etAhli;

    Button btUpload, btSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_tambah_trainer);

        mStorageReference= FirebaseStorage.getInstance().getReference("profile_trainer");

        ch=(Button)findViewById(R.id.buttonChoose);
        up=(Button)findViewById(R.id.btn_UploadTrainer);
        img=(ImageView)findViewById(R.id.imageView);
        ch.setOnClickListener(new View.OnClickListener(){
                                  @Override
                                  public void onClick(View view){
                                      Filechoser();
                                  }
                              }
        );
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(uploadTask!=null && uploadTask.isInProgress()){
                    Toast.makeText(FormTambahTrainerActivity.this, "upload in progress",Toast.LENGTH_LONG).show();
                }else{
                    FileUploader();
                }

            }
        });

        //Inisialisasi Data Trainer
        etNamaTrainer   = (EditText) findViewById(R.id.edt_NamaTrainer);
        etPendidikan    = (EditText) findViewById(R.id.edt_Pend);
        etGym           = (EditText) findViewById(R.id.edt_HomeBase);
        etOn            = (EditText) findViewById(R.id.edt_OnCall);
        etTelepon       = (EditText) findViewById(R.id.edt_NomorTelp);
        etSosmed        = (EditText) findViewById(R.id.edt_Medsos);
        etPengalaman    = (EditText) findViewById(R.id.edt_PengKerja);
        etTarif         = (EditText) findViewById(R.id.edt_TarifPert);
        etSertifikasi   = (EditText) findViewById(R.id.edt_Sertifikasi);
        etAhli          = (EditText) findViewById(R.id.edt_Keahlian);

        // inisialisasi button submit dan upload
        btUpload        = (Button) findViewById(R.id.btn_UploadTrainer);
        btSubmit        = (Button) findViewById(R.id.btn_submit);

        // inisialisasi Firebase
        database = FirebaseDatabase.getInstance().getReference();

        //onClick pada button submit
        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                personalTrainer(new personalTrainer(
                        etNamaTrainer.getText().toString(),
                        etPendidikan.getText().toString(),
                        etGym.getText().toString(),
                        etOn.getText().toString(),
                        etTelepon.getText().toString(),
                        etSosmed.getText().toString(),
                        etPengalaman.getText().toString(),
                        etTarif.getText().toString(),
                        etSertifikasi.getText().toString(),
                        etAhli.getText().toString()));
            }
        });

    }

    private String getExtension(Uri uri){
        ContentResolver cr=getContentResolver();
        MimeTypeMap mimeTypeMap=MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(cr.getType(uri));
    }

    private void FileUploader(){
        StorageReference ref=mStorageReference.child(System.currentTimeMillis()+"."+getExtension(imguri));

        uploadTask= ref.putFile(imguri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        // Get a URL to the uploaded content
                        //Uri downloadUrl = taskSnapshot.getDownloadUrl();
                        Toast.makeText(FormTambahTrainerActivity.this, "image uploaded succesfully",Toast.LENGTH_LONG).show();
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && resultCode==RESULT_OK && data!=null && data.getData()!=null){
            imguri=data.getData();
            img.setImageURI(imguri);
        }
    }

    public void personalTrainer(personalTrainer personal_trainer){
        database.child("DATA TRAINER").push().setValue(personal_trainer).addOnSuccessListener(this,
                new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
               etNamaTrainer.setText("");
               etPendidikan.setText("");
               etGym.setText("");
               etOn.setText("");
               etTelepon.setText("");
               etSosmed.setText("");
               etPengalaman.setText("");
               etTarif.setText("");
               etSertifikasi.setText("");
               etAhli.setText("");

                Snackbar.make(findViewById(R.id.btn_submit),"Data Berhasil Ditambahkan", Snackbar.LENGTH_LONG).show();

            }
        });
    }

    public static Intent getActIntent(Activity activity){
        return new Intent(activity, FormTambahTrainerActivity.class);
    }

}
