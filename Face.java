import org.opencv.core.*;
import org.opencv.imgcodecs.*; 
import org.opencv.imgproc.*; 
import org.opencv.objdetect.*;
import java.io.*;
import java.lang.*;
public class Face
{ 
    public static void main(String args[])throws IOException 
    { 
        System.loadLibrary("opencv_java411");
        CascadeClassifier faceDetector = new CascadeClassifier(); 
        faceDetector.load("trainface.xml"); 
        InputStreamReader read =new InputStreamReader(System.in);
        BufferedReader in =new BufferedReader(read); 
        System.out.println("Enter Image Path.");
        String picture=in.readLine();
        picture = picture.replace("\n", "").replace("\r", "");
        Mat image = Imgcodecs.imread(picture); 
        MatOfRect faces = new MatOfRect(); 
        faceDetector.detectMultiScale(image, faces, 1.1, 5, 0); 
  
        // Creating a rectangular box showing faces detected 
        for (Rect rect : faces.toArray()) 
        { 
            Imgproc.rectangle(image, new Point(rect.x, rect.y), 
             new Point(rect.x + rect.width, rect.y + rect.height),new Scalar(0, 255, 0),2); 
        } 
  
        // Saving the output image 
        String filename = "Output.jpg"; 
        Imgcodecs.imwrite(filename, image); 
    } 
} 