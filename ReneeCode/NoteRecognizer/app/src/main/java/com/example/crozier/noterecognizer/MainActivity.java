package com.example.crozier.noterecognizer;

import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
//import android.media.audiofx;
import be.tarsos.dsp.AudioDispatcher;
import be.tarsos.dsp.AudioEvent;
import be.tarsos.dsp.io.android.AudioDispatcherFactory;
import be.tarsos.dsp.pitch.PitchDetectionHandler;
import be.tarsos.dsp.pitch.PitchDetectionResult;
import be.tarsos.dsp.pitch.PitchProcessor;
import android.media.audiofx.*;
import android.media.AudioManager;

public class MainActivity extends AppCompatActivity {
    float frequency;
    private final float mAlpha = 0.675f;
    float filteredHz;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AudioDispatcher dispatcher = AudioDispatcherFactory.fromDefaultMicrophone(22050, 1024, 0);

        //Taken from Tarsos
        dispatcher.addAudioProcessor(new PitchProcessor(PitchProcessor.PitchEstimationAlgorithm.FFT_YIN, 22050, 1024, new PitchDetectionHandler() {

            @Override
            public void handlePitch(PitchDetectionResult pitchDetectionResult,
                                    AudioEvent audioEvent) {
                final float pitchInHz = pitchDetectionResult.getPitch();
                //From Liamm on the discussion boards
                filteredHz = lowPass(pitchInHz, filteredHz);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        TextView letter = (TextView) findViewById(R.id.tvLetter);
                        TextView sub = (TextView) findViewById(R.id.tvSub);
                        TextView sup = (TextView) findViewById(R.id.tvSuper);
                        setNoteText(filteredHz, letter, sub, sup);
                    }
                });

            }
        }));
        new Thread(dispatcher, "Audio Dispatcher").start();

    }
        /*new Thread(dispatcher,"Audio Dispatcher").start();

        int minSize = AudioRecord.getMinBufferSize(sampleRate,AudioFormat.
                        CHANNEL_CONFIGURATION_MONO,
                AudioFormat.ENCODING_PCM_16BIT);
        AudioRecord audioInput = new AudioRecord(MediaRecorder.AudioSource.MIC, sampleRate,
                AudioFormat.CHANNEL_CONFIGURATION_MONO,
                AudioFormat.ENCODING_PCM_16BIT);
        minSize);

        short[] buffer = new short[readSize];
        audioInput.startRecording();
        audioInput.read(buffer, index, readSize);*/

    //Debugged by Cameron
    public void setNoteText(float frequency, TextView tv1, TextView tv2, TextView tv3){

        String letter;
        String subscript;
        String superscript;

        //final TextView letter = (TextView) findViewById(R.id.letter);
        //This code is from Cameron - posted in the discussion board
        if      (  15.00  <=     frequency && frequency <  16.84  ) { letter = "C"; superscript = ""      ; subscript = " 0      " ; }
        else if (  16.84  <=     frequency && frequency <  17.84  ) { letter = "D"; superscript = " \u266D "; subscript = " 0  " ; }
        else if (  17.84  <=     frequency && frequency <  18.90  ) { letter = "D"; superscript = "    "; subscript = " 0  " ; }
        else if (  18.90  <=     frequency && frequency <  20.03  ) { letter = "E"; superscript = " \u266D "; subscript = " 0  " ; }
        else if (  20.03  <=     frequency && frequency <  21.22  ) { letter = "E"; superscript = "    "; subscript = " 0  " ; }
        else if (  21.22  <=     frequency && frequency <  22.48  ) { letter = "F"; superscript = "    "; subscript = " 0  " ; }
        else if (  22.48  <=     frequency && frequency <  23.81  ) { letter = "G"; superscript = " \u266D "; subscript = " 0  " ; }
        else if (  23.81  <=     frequency && frequency <  25.23  ) { letter = "G"; superscript = "    "; subscript = " 0  " ; }
        else if (  25.23  <=     frequency && frequency <  26.73  ) { letter = "A"; superscript = " \u266D "; subscript = " 0  " ; }
        else if (  26.73  <=     frequency && frequency <  28.32  ) { letter = "A"; superscript = "    "; subscript = " 0  " ; }
        else if (  28.32  <=     frequency && frequency <  30.01  ) { letter = "B"; superscript = " \u266D "; subscript = " 0  " ; }
        else if (  30.01  <=     frequency && frequency <  31.79  ) { letter = "B"; superscript = "    "; subscript = " 0  " ; }
        else if (  31.79  <=     frequency && frequency <  33.68  ) { letter = "C"; superscript = "    "; subscript = " 1  " ; }
        else if (  33.68  <=     frequency && frequency <  35.68  ) { letter = "D"; superscript = " \u266D "; subscript = " 1  " ; }
        else if (  35.68  <=     frequency && frequency <  37.80  ) { letter = "D"; superscript = "    "; subscript = " 1  " ; }
        else if (  37.80  <=     frequency && frequency <  40.05  ) { letter = "E"; superscript = " \u266D "; subscript = " 1  " ; }
        else if (  40.05  <=     frequency && frequency <  42.43  ) { letter = "E"; superscript = "    "; subscript = " 1  " ; }
        else if (  42.43  <=     frequency && frequency <  44.95  ) { letter = "F"; superscript = "    "; subscript = " 1  " ; }
        else if (  44.95  <=     frequency && frequency <  47.63  ) { letter = "G"; superscript = " \u266D "; subscript = " 1  " ; }
        else if (  47.63  <=     frequency && frequency <  50.46  ) { letter = "G"; superscript = "    "; subscript = " 1  " ; }
        else if (  50.46  <=     frequency && frequency <  53.46  ) { letter = "A"; superscript = " \u266D "; subscript = " 1  " ; }
        else if (  53.46  <=     frequency && frequency <  56.64  ) { letter = "A"; superscript = "    "; subscript = " 1  " ; }
        else if (  56.64  <=     frequency && frequency <  60.01  ) { letter = "B"; superscript = " \u266D "; subscript = " 1  " ; }
        else if (  60.01  <=     frequency && frequency <  63.58  ) { letter = "B"; superscript = "    "; subscript = " 1  " ; }
        else if (  63.58  <=     frequency && frequency <  67.36  ) { letter = "C"; superscript = "    "; subscript = " 2  " ; }
        else if (  67.36  <=     frequency && frequency <  71.36  ) { letter = "D"; superscript = " \u266D "; subscript = " 2  " ; }
        else if (  71.36  <=     frequency && frequency <  75.60  ) { letter = "D"; superscript = "    "; subscript = " 2  " ; }
        else if (  75.60  <=     frequency && frequency <  80.10  ) { letter = "E"; superscript = " \u266D "; subscript = " 2  " ; }
        else if (  80.10  <=     frequency && frequency <  84.86  ) { letter = "E"; superscript = "    "; subscript = " 2  " ; }
        else if (  84.86  <=     frequency && frequency <  89.91  ) { letter = "F"; superscript = "    "; subscript = " 2  " ; }
        else if (  89.91  <=     frequency && frequency <  95.25  ) { letter = "G"; superscript = " \u266D "; subscript = " 2  " ; }
        else if (  95.25  <=     frequency && frequency <  100.92 ) { letter = "G"; superscript = "    "; subscript = " 2  " ; }
        else if (  100.92 <=     frequency && frequency <  106.92 ) { letter = "A"; superscript = " \u266D "; subscript = " 2  " ; }
        else if (  106.92 <=     frequency && frequency <  113.27 ) { letter = "A"; superscript = "    "; subscript = " 2  " ; }
        else if (  113.27 <=     frequency && frequency <  120.01 ) { letter = "B"; superscript = " \u266D "; subscript = " 2  " ; }
        else if (  120.01 <=     frequency && frequency <  127.14 ) { letter = "B"; superscript = "    "; subscript = " 2  " ; }
        else if (  127.14 <=     frequency && frequency <  134.70 ) { letter = "C"; superscript = "    "; subscript = " 3  " ; }
        else if (  134.70 <=     frequency && frequency <  142.71 ) { letter = "D"; superscript = " \u266D "; subscript = " 3  " ; }
        else if (  142.71 <=     frequency && frequency <  151.20 ) { letter = "D"; superscript = "    "; subscript = " 3  " ; }
        else if (  151.20 <=     frequency && frequency <  160.19 ) { letter = "E"; superscript = " \u266D "; subscript = " 3  " ; }
        else if (  160.19 <=     frequency && frequency <  169.71 ) { letter = "E"; superscript = "    "; subscript = " 3  " ; }
        else if (  169.71 <=     frequency && frequency <  179.81 ) { letter = "F"; superscript = "    "; subscript = " 3  " ; }
        else if (  179.81 <=     frequency && frequency <  190.50 ) { letter = "G"; superscript = " \u266D "; subscript = " 3  " ; }
        else if (  190.50 <=     frequency && frequency <  201.83 ) { letter = "G"; superscript = "    "; subscript = " 3  " ; }
        else if (  201.83 <=     frequency && frequency <  213.83 ) { letter = "A"; superscript = " \u266D "; subscript = " 3  " ; }
        else if (  213.83 <=     frequency && frequency <  226.54 ) { letter = "A"; superscript = "    "; subscript = " 3  " ; }
        else if (  226.54 <=     frequency && frequency <  240.01 ) { letter = "B"; superscript = " \u266D "; subscript = " 3  " ; }
        else if (  240.01 <=     frequency && frequency <  254.29 ) { letter = "B"; superscript = "    "; subscript = " 3  " ; }
        else if (  254.29 <=     frequency && frequency <  269.41 ) { letter = "C"; superscript = "    "; subscript = " 4  " ; }
        else if (  269.41 <=     frequency && frequency <  285.42 ) { letter = "D"; superscript = " \u266D "; subscript = " 4  " ; }
        else if (  285.42 <=     frequency && frequency <  302.40 ) { letter = "D"; superscript = "    "; subscript = " 4  " ; }
        else if (  302.40 <=     frequency && frequency <  320.38 ) { letter = "E"; superscript = " \u266D "; subscript = " 4  " ; }
        else if (  320.38 <=     frequency && frequency <  339.43 ) { letter = "E"; superscript = "    "; subscript = " 4  " ; }
        else if (  339.43 <=     frequency && frequency <  359.61 ) { letter = "F"; superscript = "    "; subscript = " 4  " ; }
        else if (  359.61 <=     frequency && frequency <  381.00 ) { letter = "G"; superscript = " \u266D "; subscript = " 4  " ; }
        else if (  381.00 <=     frequency && frequency <  403.65 ) { letter = "G"; superscript = "    "; subscript = " 4  " ; }
        else if (  403.65 <=     frequency && frequency <  427.65 ) { letter = "A"; superscript = " \u266D "; subscript = " 4  " ; }
        else if (  427.65 <=     frequency && frequency <  453.08 ) { letter = "A"; superscript = "    "; subscript = " 4  " ; }
        else if (  453.08 <=     frequency && frequency <  480.02 ) { letter = "B"; superscript = " \u266D "; subscript = " 4  " ; }
        else if (  480.02 <=     frequency && frequency <  508.57 ) { letter = "B"; superscript = "    "; subscript = " 4  " ; }
        else if (  508.57 <=     frequency && frequency <  538.81 ) { letter = "C"; superscript = "    "; subscript = " 5  " ; }
        else if (  538.81 <=     frequency && frequency <  570.85 ) { letter = "D"; superscript = " \u266D "; subscript = " 5  " ; }
        else if (  570.85 <=     frequency && frequency <  604.79 ) { letter = "D"; superscript = "    "; subscript = " 5  " ; }
        else if (  604.79 <=     frequency && frequency <  640.75 ) { letter = "E"; superscript = " \u266D "; subscript = " 5  " ; }
        else if (  640.75 <=     frequency && frequency <  678.86 ) { letter = "E"; superscript = "    "; subscript = " 5  " ; }
        else if (  678.86 <=     frequency && frequency <  719.23 ) { letter = "F"; superscript = "    "; subscript = " 5  " ; }
        else if (  719.23 <=     frequency && frequency <  761.99 ) { letter = "G"; superscript = " \u266D "; subscript = " 5  " ; }
        else if (  761.99 <=     frequency && frequency <  807.30 ) { letter = "G"; superscript = "    "; subscript = " 5  " ; }
        else if (  807.30 <=     frequency && frequency <  855.31 ) { letter = "A"; superscript = " \u266D "; subscript = " 5  " ; }
        else if (  855.31 <=     frequency && frequency <  906.17 ) { letter = "A"; superscript = "    "; subscript = " 5  " ; }
        else if (  906.17 <=     frequency && frequency <  960.05 ) { letter = "B"; superscript = " \u266D "; subscript = " 5  " ; }
        else if (  960.05 <=     frequency && frequency <  1017.14    ) { letter = "B"; superscript = "    "; subscript = " 5  " ; }
        else if (  1017.14    <=     frequency && frequency <  1077.62    ) { letter = "C"; superscript = "    "; subscript = " 6  " ; }
        else if (  1077.62    <=     frequency && frequency <  1141.70    ) { letter = "D"; superscript = " \u266D "; subscript = " 6  " ; }
        else if (  1141.70    <=     frequency && frequency <  1209.59    ) { letter = "D"; superscript = "    "; subscript = " 6  " ; }
        else if (  1209.59    <=     frequency && frequency <  1281.51    ) { letter = "E"; superscript = " \u266D "; subscript = " 6  " ; }
        else if (  1281.51    <=     frequency && frequency <  1357.71    ) { letter = "E"; superscript = "    "; subscript = " 6  " ; }
        else if (  1357.71    <=     frequency && frequency <  1438.45    ) { letter = "F"; superscript = "    "; subscript = " 6  " ; }
        else if (  1438.45    <=     frequency && frequency <  1523.98    ) { letter = "G"; superscript = " \u266D "; subscript = " 6  " ; }
        else if (  1523.98    <=     frequency && frequency <  1614.60    ) { letter = "G"; superscript = "    "; subscript = " 6  " ; }
        else if (  1614.60    <=     frequency && frequency <  1710.61    ) { letter = "A"; superscript = " \u266D "; subscript = " 6  " ; }
        else if (  1710.61    <=     frequency && frequency <  1812.33    ) { letter = "A"; superscript = "    "; subscript = " 6  " ; }
        else if (  1812.33    <=     frequency && frequency <  1920.10    ) { letter = "B"; superscript = " \u266D "; subscript = " 6  " ; }
        else if (  1920.10    <=     frequency && frequency <  2034.27    ) { letter = "B"; superscript = "    "; subscript = " 6  " ; }
        else if (  2034.27    <=     frequency && frequency <  2155.23    ) { letter = "C"; superscript = "    "; subscript = " 7  " ; }
        else if (  2155.23    <=     frequency && frequency <  2283.39    ) { letter = "D"; superscript = " \u266D "; subscript = " 7  " ; }
        else if (  2283.39    <=     frequency && frequency <  2419.17    ) { letter = "D"; superscript = "    "; subscript = " 7  " ; }
        else if (  2419.17    <=     frequency && frequency <  2563.02    ) { letter = "E"; superscript = " \u266D "; subscript = " 7  " ; }
        else if (  2563.02    <=     frequency && frequency <  2715.43    ) { letter = "E"; superscript = "    "; subscript = " 7  " ; }
        else if (  2715.43    <=     frequency && frequency <  2876.90    ) { letter = "F"; superscript = "    "; subscript = " 7  " ; }
        else if (  2876.90    <=     frequency && frequency <  3047.96    ) { letter = "G"; superscript = " \u266D "; subscript = " 7  " ; }
        else if (  3047.96    <=     frequency && frequency <  3229.20    ) { letter = "G"; superscript = "    "; subscript = " 7  " ; }
        else if (  3229.20    <=     frequency && frequency <  3421.22    ) { letter = "A"; superscript = " \u266D "; subscript = " 7  " ; }
        else if (  3421.22    <=     frequency && frequency <  3624.66    ) { letter = "A"; superscript = "    "; subscript = " 7  " ; }
        else if (  3624.66    <=     frequency && frequency <  3840.19    ) { letter = "B"; superscript = " \u266D "; subscript = " 7  " ; }
        else if (  3840.19    <=     frequency && frequency <  4068.54    ) { letter = "B"; superscript = "    "; subscript = " 7  " ; }
        else if (  4068.54    <=     frequency && frequency <  4310.47    ) { letter = "C"; superscript = "    "; subscript = " 8  " ; }
        else if (  4310.47    <=     frequency && frequency <  4566.78    ) { letter = "D"; superscript = " \u266D "; subscript = " 8  " ; }
        else if (  4566.78    <=     frequency && frequency <  4838.33    ) { letter = "D"; superscript = "    "; subscript = " 8  " ; }
        else if (  4838.33    <=     frequency && frequency <  5126.04    ) { letter = "E"; superscript = " \u266D "; subscript = " 8  " ; }
        else if (  5126.04    <=     frequency && frequency <  5430.85    ) { letter = "E"; superscript = "    "; subscript = " 8  " ; }
        else if (  5430.85    <=     frequency && frequency <  5753.78    ) { letter = "F"; superscript = "    "; subscript = " 8  " ; }
        else if (  5753.78    <=     frequency && frequency <  6095.92    ) { letter = "G"; superscript = " \u266D "; subscript = " 8  " ; }
        else if (  6095.92    <=     frequency && frequency <  6458.41    ) { letter = "G"; superscript = "    "; subscript = " 8  " ; }
        else if (  6458.41    <=     frequency && frequency <  6842.44    ) { letter = "A"; superscript = " \u266D "; subscript = " 8  " ; }
        else if (  6842.44    <=     frequency && frequency <  7249.31    ) { letter = "A"; superscript = "    "; subscript = " 8  " ; }
        else if (  7249.31    <=     frequency && frequency <  7680.38    ) { letter = "B"; superscript = " \u266D "; subscript = " 8  " ; }
        else if (  7680.38    <=     frequency && frequency <  3951.07    ) { letter = "B"; superscript = "    "; subscript = " 8  " ; }
        else {
            letter = "";
            superscript = "";
            subscript = "";
        }

            tv1.setText(letter);
            tv2.setText(superscript);
            tv3.setText(subscript);

        //Code from my Grizzly Colors app
        final ImageButton button = (ImageButton) findViewById(R.id.aboutBtn);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "By: Renee (in picture) on November 14th", Toast.LENGTH_SHORT).show();

            }
        });
        }

    //From Liam on discussion board
    private float lowPass(float current, float original) {
        return original * mAlpha + current * (1 - mAlpha);
    }







}

