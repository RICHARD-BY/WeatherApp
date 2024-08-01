import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WeatherAppGui extends JFrame {
    public WeatherAppGui() {
        //setup out gui  and add a title
        super("Weather App");

        //configure gui to end the program's process once it has been closed

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // set the size of our gui (in pixels)

        setSize(450, 650);

        //load our gui at the centre of the screen

        setLocationRelativeTo(null);

        //make our layout manager to null to manually position components within the gui

        setLayout(null);

        //prevent any resize of our gui

        setResizable(false);

        addGuiComponents();


    }

    private void addGuiComponents() {
        //search field

        JTextField searchTextField = new JTextField();

        //set the location and size of the component

        searchTextField.setBounds(15, 15, 351, 45);

        //change the font style and size

        searchTextField.setFont(new Font("Dialog", Font.PLAIN, 24));

        add(searchTextField);

        //search button

        JButton searchButton = new JButton(loadImage("src/assets/weatherapp_images/search.png"));

        //change the cursor to a hand cursorwhen hovering over this button

        searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        searchButton.setBounds(375,13,47,45);
        add(searchButton);
    }

    //used to create images in our gui components
    private  ImageIcon loadImage(String resourcepath) {
        try{
            //read the image file from the path give
            BufferedImage image = ImageIO.read(new File(resourcepath));

            //returns an image icon so that our component can render it

            return new ImageIcon(image);

        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("could not find resource");
        return null;
    }
}

