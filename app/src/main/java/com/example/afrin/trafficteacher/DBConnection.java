package com.example.afrin.trafficteacher;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class DBConnection extends SQLiteOpenHelper {
    public static final String TABLE_NAME1 = "quiz_normal";
    public static final String TABLE_NAME2 = "quiz_image";
    public static final String COLUMN_QUESTION = "question";
    public static final String COLUMN_OPTION1 = "option1";
    public static final String COLUMN_OPTION2 = "option2";
    public static final String COLUMN_OPTION3 = "option3";
    public static final String COLUMN_OPTION4 = "option4";
    public static final String COLUMN_ANSWER_NR = "answerNr";
    private static String DB_PATH = "/data/data/com.example.afrin.trafficteacher/databases/";
    private static String DB_NAME = "traffic.db";
    private SQLiteDatabase sqLiteDatabase;
    private Context context = null;
    public DBConnection(@Nullable Context context) {
        super(context, DB_NAME, null, 1);
        this.context = context;
    }

    public void createDataBase() {
        boolean dbExixts = checkDataBase();
        if (dbExixts) {

        } else {
            this.getReadableDatabase();
            try {
                copyDataBase();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    }

    private void copyDataBase() {
        try {
            //Open your local db as the input stream
            InputStream inputStream = context.getAssets().open(DB_NAME);

            // Path to the just created empty db
            String outFileName = DB_PATH + DB_NAME;

            //Open the empty db as the output stream
            OutputStream outputStream = new FileOutputStream(outFileName);

            //transfer bytes from the inputfile to the outputfile
            byte[] buffer = new byte[1024];
            int length;

            while ((length = inputStream.read(buffer)) > 0) {

                outputStream.write(buffer, 0, length);
            }

            //Close the streams
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        }catch (IOException ex){

        }


    }

    public boolean checkDataBase() {
        SQLiteDatabase tempDB = null;

        try {
            String myPath = DB_PATH + DB_NAME;
            tempDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);

        } catch (Exception e) {

        }

        if (tempDB != null) {
            tempDB.close();
        }

        return tempDB != null ? true : false;

    }

    public void openDataBase() {
        String myPath = DB_PATH + DB_NAME;
        sqLiteDatabase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);

    }

    @Override
    public synchronized void close() {
        if (sqLiteDatabase != null)
            sqLiteDatabase.close();
        super.close();
    }

    public void ejecutar() {

    }

    public List<Question> getAllQuestions(String table_name) {
        List<Question> questionList = new ArrayList<>();
        sqLiteDatabase = getReadableDatabase();
        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM " + table_name, null);

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(COLUMN_ANSWER_NR)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
