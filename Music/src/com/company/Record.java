package com.company;

/**
 * Created by ����� on 26.04.2015.
 */
public class Record
{
    private String recordFileName = "New Record ";
    private String recordFilePath = "";

    public void recordMusic ()
    {
        // recording
        eliminateExcessNoise();
    }

    private void eliminateExcessNoise ()
    {

    }

    public void saveRecord (int recordNo)
    {
        recordFileName += Integer.toString(recordNo);
    }
}
