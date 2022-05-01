import java.awt.Graphics;

/**
 * Implements the list of messages for teletext
 */
public class TeletextList
{
  private ListNode2 heading, topNode;

  /**
   * Creates a circular list of headlines.
   * First creates a circular list with one node, "Today's headlines:".
   * Saves a reference to that node in heading.
   * Adds a node holding an empty string before heading
   * and another node holding an empty string after heading.
   * Appends all the strings from headlines to the list, after
   * the blank line that follows heading,
   * preserving their order.  Sets topNode equal to heading.
   */
  public TeletextList(String[] headlines)
  {
	  heading=new ListNode2("Today's headlines:");
	  topNode=heading;
	  heading.setPrevious(heading);
	  heading.setNext(heading);
	  ListNode2 firstBlank = addAfter(heading, "");
	  ListNode2 lastBlank = addBefore(heading, "");
	  ListNode2 check = firstBlank;
	  for(int i = 0; i < headlines.length; i++) {
		  ListNode2 node = addAfter(check, headlines[i]);
		  check = node;
	  }
	  check.setNext(lastBlank);
	  lastBlank.setPrevious(check);
  }

  /**
   * Inserts a node with msg into the headlines list after the blank
   * line that follows heading.
   */
  public void insert(String msg)
  {
	  ListNode2 firstBlank = heading.getNext();
	  addAfter(firstBlank, msg);
  }

  /**
   * Deletes the node that follows topNode from the headlines list,
   * unless that node happens to be heading or the node before or after
   * heading that holds a blank line.
   */
  public void delete()
  {
	  if(topNode!=null) {
		  if(!topNode.getNext().getValue().equals("") && !topNode.getNext().getValue().equals("Today's headlines:")) {
	  
	  remove(topNode.getNext());
	  }
	  }
  }

  /**
   * Scrolls up the headlines list, advancing topNode to the next node.
   */
  public void scrollUp()
  {
	  topNode=topNode.getNext();
  }

  /**
   * Adds a new node with msg to the headlines list before a given node.
   * Returns a reference to the added node.
   */
  private ListNode2 addBefore(ListNode2 node, String msg)
  {
	  ListNode2 address = topNode;
	  ListNode2 toAdd = new ListNode2(msg);
	  boolean harold = false;
	  while(address!=node) {
		  address=address.getNext();
		  if(!harold)
			  harold=true;
		  if(harold&&address==topNode)
			  return null;
	  }
	  ListNode2 prev = address.getPrevious();
	  prev.setNext(toAdd);
	  toAdd.setPrevious(prev);
	  address.setPrevious(toAdd);
	  toAdd.setNext(address);
	  return toAdd;
  }

  /**
   * Adds a new node with msg to the headlines list after a given node.
   * Returns a reference to the added node.
   */
  private ListNode2 addAfter(ListNode2 node, String msg)
  {
	  ListNode2 address = topNode;
	  ListNode2 toAdd = new ListNode2(msg);
	  boolean harold = false;
	  while(address!=node) {
		  address=address.getNext();
		  if(!harold)
			  harold=true;
		  if(harold&&address==topNode)
			  return null;
	  }
	  ListNode2 next = address.getNext();
	  address.setNext(toAdd);
	  toAdd.setPrevious(address);
	  next.setPrevious(toAdd);
	  toAdd.setNext(next);
	  return toAdd;
	  
  }

  /**
   * Removes a given node from the list.
   */
  private void remove(ListNode2 node)
  {
	  node.getPrevious().setNext(node.getNext());
	  node.getNext().setPrevious(node.getPrevious());
  }

  /**
   * Draws nLines headlines in g, starting with topNode at x, y
   * and incrementing y by lineHeight after each headline.
   */
  public void draw(Graphics g, int x, int y, int lineHeight, int nLines)
  {
    ListNode2 node = topNode;
    for (int k = 1; k <= nLines; k++)
    {
      g.drawString((String)node.getValue(), x, y);
      y += lineHeight;
      node = node.getNext();
    }
  }
}
