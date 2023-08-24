//Source code
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.*;
import javafx.event.*;
import javafx.scene.input.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import java.io.*;

public class radio extends Application
{
  public void start(Stage sd)
  {
    File f=new File("radioo.txt");
    if(!f.exists())
           System.out.println("file not found");
    else
        {
          try
          {
             FileReader f1=new FileReader(f);
             BufferedReader bf=new BufferedReader(f1);

             String s;
             Label l[]=new Label[8];
             RadioButton r[]=new RadioButton[32];
             ToggleGroup t[]=new ToggleGroup[8];

             VBox v=new VBox();
             for(int r1=0,j=0;(s=bf.readLine())!=null;)
           {
                    l[j]=new Label(s);
                    t[j]=new ToggleGroup();
                    v.getChildren().add(l[j]);
             for(int i=0;i<4;i++)
             {
		r[r1+i]=new RadioButton(bf.readLine());
                v.getChildren().add(r[r1+i]);
		r[r1+i].setToggleGroup(t[j]);
	     }   
                j++;
		r1+=4 ;
           }
           bf.close();
	   f1.close();

           Button b=new Button("Submit");
           Label l1=new Label();
           Label l2=new Label();

           EventHandler<ActionEvent>ae=new EventHandler<ActionEvent>()
           {
             public void handle(ActionEvent e)
	     {
               int ans=0;
             if(true)
               {
 	       if(r[2].isSelected())
                  ans++;
               if(r[5].isSelected())
 		  ans++;
               if(r[9].isSelected())
 		  ans++;
               if(r[14].isSelected())
                  ans++;
               if(r[17].isSelected())
 		  ans++;
               if(r[20].isSelected())
 		  ans++;
               if(r[25].isSelected())
 		  ans++;
              }
              l1.setText("Right answers "+ans);
              int aa=7-ans;
              l2.setText("Wrong answers "+aa);
             }
           };

           b.setOnAction(ae);
           v.getChildren().addAll(b,l1,l2);
           Group g=new Group(v);
           Scene s1=new Scene(g);
	   sd.setScene(s1);
           sd.setTitle("Space Based MCQ's");
           sd.setHeight(760);
           sd.setWidth(1360);
	   sd.show();
        }
        catch(Exception e)
         {
            System.out.println("Some Exception occurs");
         }
      }
    }
         
    public static void main(String ad[])
    {
        launch();
    }
}

            
		    
