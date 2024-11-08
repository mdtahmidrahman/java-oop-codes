/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ch_12;

import java.awt.FlowLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ComboBoxFrame extends JFrame
{
    private final JLabel label;
    private static final String[] names = {"z.jpeg", "GUItip.gif", "z.jpeg", "GUItip.gif"};
    private final Icon[] icons =
    {
        new ImageIcon(getClass().getResource(names[0])),
        new ImageIcon(getClass().getResource(names[1])),
        new ImageIcon(getClass().getResource(names[2])),
        new ImageIcon(getClass().getResource(names[3]))
    };
    private final JComboBox<String> imagesJComboBox;

    public ComboBoxFrame()
    {
        super("Testing JComboBox");
        setLayout(new FlowLayout());

        imagesJComboBox = new JComboBox<>(names);
        imagesJComboBox.setMaximumRowCount(3);
        imagesJComboBox.addItemListener(
            new ItemListener()
            {
                @Override
                public void itemStateChanged(ItemEvent event)
                {
                    if (event.getStateChange() == ItemEvent.SELECTED)
                        label.setIcon(icons[imagesJComboBox.getSelectedIndex()]);
                }
            }
        );
        add(imagesJComboBox);
        label = new JLabel(icons[0]);
        add(label);
    }
}
