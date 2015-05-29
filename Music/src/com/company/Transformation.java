package com.company;

//import java.lang.Math;
import org.jtransforms.fft.DoubleFFT_1D;
import pl.edu.icm.jlargearrays.DoubleLargeArray;

/**
 * Created by Мунир on 10.05.2015.
 */
public class Transformation
{
 //   public final static int INF = 10000;

    public double fourierTransform(double audioData[])
    {
      /*  DoubleFFT_1D fftDo = new DoubleFFT_1D(data.length);
        double[] fft = new double[data.length * 2];
        System.arraycopy(data, 0, fft, 0, data.length);
        fftDo.realForwardFull(fft);
        for(double d: fft) {
            System.out.println(d);
        }*/
      /*  double[] input = new double[]{
                0.0176,
                -0.0620,
                0.2467,
                0.4599,
                -0.0582,
                0.4694,
                0.0001,
                -0.2873};*/
 /*       DoubleFFT_1D fftDo = new DoubleFFT_1D(input.length);
        double[] fft = new double[input.length * 2];
        double[] magnitude = new double[input.length / 2];
        for (int i = 0; i < input.length; i++)
        {
            fft[2*i] = input[i];
            fft[2*i+1] = 0;
        }
        //System.arraycopy(input, 0, fft, 0, input.length);
        fftDo.realForwardFull(fft);
        for (int i = 0; i <= input.length / 2 - 1; i++)
        {
            double re = fft[2 * i];
            double im = fft[2 * i + 1];
            magnitude[i] = Math.sqrt(re * re + im * im);
        }
        // find largest peak in power spectrum
        double max_magnitude = -INF;
        int max_index = -1;
        for (int i = 0; i <= input.length / 2 - 1; i++)
        {
            if (magnitude[i] > max_magnitude)
            {
                max_magnitude = magnitude[i];
                max_index = i;
            }
        }
// convert index of largest peak to frequency
        float freq = max_index * 44100 / input.length / 2;
        System.out.println(freq);

        for (double d : fft) {
            System.out.println(d);
        }
        return freq;*/

        DoubleFFT_1D fft = new DoubleFFT_1D(audioData.length);

        double[] fftData = new double[audioData.length * 2];
        for (int i = 0; i < audioData.length; i++)
        {
            fftData[2 * i] = audioData[i]; 													//make buffer for fft output, 2*i is real and 2*i+1 is imaginary
            fftData[2 * i + 1] = 0;
        }
        fft.complexForward(fftData); 														//perform inplace fft on data
        double max_hz = -1;
        double max_fftval = -1;
        for (int i = 0; i < fftData.length; i += 2)
        {
            double hz = 2 * ((i / 2.0) / fftData.length) * 44100;
            double vlen = Math.sqrt(Math.pow(fftData[i], 2) + Math.pow(fftData[i + 1],2));

            if (max_fftval < vlen && hz < 8000)
            {														//find frequency with max absolute value
                max_fftval = vlen;
                max_hz = hz;
            }
        }
        System.out.printf("dominant frequency was:%f\n",max_hz);
        return max_hz;
    }
}
