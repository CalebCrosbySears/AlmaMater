package edu.csearsggc.almamater;

/**
 * Created by Caleb Sears on 11/9/2016.
 */

public class MidiNote {
    private int midiKey;
    private String[] noteArray = {"C", "C♯/D♭", "D", "D♯/E♭", "E", "F", "F♯/G♭", "G", "G♯/A♭", "A", "A♯/B♭", "B"};
    private String[] subscripts = {"₀", "\u2081", "₂", "₃", "₄", "₅", "₆", "₇", "₈", "₉", "₁₀"};
    private String note;

    private int[] cNotes = {12, 24, 36, 48, 60, 72, 84, 96, 108, 120};
    private int[] csNotes = {1, 13, 25, 37, 49, 61, 73, 85, 97, 109, 121};
    private int[] dNotes = {2, 14, 26, 38, 50, 62, 74, 86, 98, 110, 122};
    private int[] dsNotes = {3, 15, 27, 39, 51, 63, 75, 87, 99, 111, 123};
    private int[] eNotes = {4, 16, 28, 40, 52, 64, 76, 88, 100, 112, 124};
    private int[] fNotes = {5, 17, 29, 41, 53, 65, 77, 89, 101, 113, 125};
    private int[] fsNotes = {6, 18, 30, 42, 54, 66, 78, 90, 102, 114, 126};
    private int[] gNotes = {7, 19, 31, 43, 55, 67, 79, 91, 103, 115, 127};
    private int[] gsNotes = {8, 20, 32, 44, 56, 68, 80, 92, 104, 116};
    private int[] aNotes = {9, 21, 33, 45, 57, 69, 81, 93, 105, 117};
    private int[] asNotes = {10, 22, 34, 46, 58, 70, 82, 94, 106, 118};
    private int[] bNotes = {11, 23, 35, 47, 59, 71, 83, 95, 107, 119};

    public MidiNote(int _midiKey) {
        midiKey = _midiKey;
        note = "";
    }

    public String getNote(){

        for (int i = 0; i < 10; i++) {
            if (midiKey == cNotes[i]) {
                note = noteArray[0] + subscripts[i - 1];
            } else
            if (midiKey == csNotes[i]) {
                note = noteArray[1] + subscripts[i - 1];
            } else
            if (midiKey == dNotes[i]) {
                note = noteArray[2] + subscripts[i - 1];
            } else
            if (midiKey == dsNotes[i]) {
                note = noteArray[3] + subscripts[i - 1];
            } else
            if (midiKey == eNotes[i]) {
                note = noteArray[4] + subscripts[i - 1];
            } else
            if (midiKey == fNotes[i]) {
                note = noteArray[5] + subscripts[i - 1];
            } else
            if (midiKey == fsNotes[i]) {
                note = noteArray[6] + subscripts[i - 1];
            } else
            if (midiKey == gNotes[i]) {
                note = noteArray[7] + subscripts[i - 1];
            } else
            if (midiKey == gsNotes[i]) {
                note = noteArray[8] + subscripts[i - 1];
            } else
            if (midiKey == aNotes[i]) {
                note = noteArray[9] + subscripts[i - 1];
            } else
            if (midiKey == asNotes[i]) {
                note = noteArray[10] + subscripts[i - 1];
            } else
            if (midiKey == bNotes[i]) {
                note = noteArray[11] + subscripts[i - 1];
            }

        }

        return note;
    }
}
