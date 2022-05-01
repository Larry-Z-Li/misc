import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Implements the list of messages for teletext
 */
public class TeletextAList
{
  private int heading, top;
  private ArrayList<String> headlines;

  /**
   * Creates an arraylist of headlines.
   * First creates a heading, "Today's headlines:".
   * Saves the index of that heading in the variable "heading".
   * Adds a headline with an empty string after heading
   * and another headline with an empty string before heading.
   * Appends all the strings from headlines to the list, after
   * the blank line that follows heading,
   * preserving their order.  Sets top equal to heading.
   */
  public TeletextAList(String[] headlines)
  {
	  this.headlines = new ArrayList<String>();
	  this.headlines.add("");
	  this.headlines.add("Today's headlines:");
	  this.headlines.add("");
	  heading = 1;
	  top = heading;
	  for(int i = 0; i < headlines.length; i++) {
		  this.headlines.add(headlines[i]);
	  }
	  
  }

  /**
   * Inserts a headline with msg into the headlines list after the blank
   * line that follows heading.
   */
  public void insert(String msg)
  {
	  if(heading + 2 < headlines.size())
	  headlines.add(heading+2, msg);
  }

  /**
   * Deletes the headline that follows top from the headlines list,
   * unless that headline happens to be heading or the headline before or after
   * heading that holds a blank line.
   */
  public void delete()
  {
	  if(top+1<headlines.size()) {
	  if(!headlines.get(top+1).equals("Today's headlines:") && !headlines.get(top+1).equals(""))
	  remove(top+1);
	  }
  }

  /**
   * Scrolls up the headlines list, advancing top to the next headline.
   */
  public void scrollUp()
  {
	  if(top == headlines.size()-1)
	  top=0;
	  else
		  top++;
  }

  /**
   * Adds a new headline with msg to the headlines list before a given index.
   */
  private void addBefore(int index, String msg)
  {
	  headlines.add(index-1, msg);
  }

  /**
   * Adds a new headline with msg to the headlines list after a given index.
   */
  private void addAfter(int index, String msg)
  {
	  headlines.add(index+1, msg);
  }

  /**
   * Removes a headline at a given index from the list.
   */
  private void remove(int index)
  {
	  headlines.remove(index);
  }

  /**
   * Draws nLines headlines in g, starting with topNode at x, y
   * and incrementing y by lineHeight after each headline.
   */
  public void draw(Graphics g, int x, int y, int lineHeight, int nLines)
  {
    int index = top;
    for (int k = 1; k <= nLines; k++)
    {
      g.drawString(headlines.get(index % headlines.size()), x, y);
      y += lineHeight;
      index++;
    }
  }
}
