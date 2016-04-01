package com.javalj.androidapp4demo.main;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by lijie on 2016/3/28.
 */
public class ContanctsActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView = new TextView(this);
        textView.setText("helloworld");
        setContentView(textView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectContact();
            }
        });
    }


    static final int REQUEST_SELECT_CONTACT = 1;

    public void selectContact() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_SELECT_CONTACT);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SELECT_CONTACT && resultCode == RESULT_OK) {
            Uri contactUri = data.getData();
            // Do something with the selected contact at contactUri
            //  contactUri.getEncodedUserInfo();iI
            Cursor cursor = managedQuery(contactUri, null, null, null, null);
            cursor.moveToFirst();
            Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();
        }
    }
}
