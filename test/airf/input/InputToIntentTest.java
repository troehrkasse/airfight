package airf.input;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.newdawn.slick.Input;

import airf.component.Position;

import com.artemis.Entity;
import com.artemis.World;

public class InputToIntentTest
{

    @Before
    public void setUp() throws Exception
    {
    }

    @Test
    public void testSelectJet()
    {
        int screenHeight = 1000;
        World w = new World();
        InputToIntent i = new InputToIntent(screenHeight);
        Entity jet1 = w.createEntity();
        Entity jet2 = w.createEntity();
        
        Position pos = new Position();
        pos.x = 0;
        pos.y = 0;
        jet1.addComponent(pos);
        i.addJet(jet1);
        
        pos = new Position();
        pos.x = 200;
        pos.y = 200;
        jet2.addComponent(pos);
        i.addJet(jet2);
        
        i.setSelectedJet(jet1);
        assertTrue(i.getSelectedJet() == jet1);
        i.mousePressed(Input.MOUSE_LEFT_BUTTON, 2, 4);
        assertTrue(i.getSelectedJet() == jet2);
        i.mousePressed(Input.MOUSE_LEFT_BUTTON, 900, 150);
        assertTrue(i.getSelectedJet() == jet1);
    }

}
