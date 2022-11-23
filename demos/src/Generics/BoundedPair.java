
 
public class BoundedPair<T extends Comparable> 
{
    private T first;
    private T second;

    public T max( )
    {
        if (first.compareTo(second) > 0)
            return first;
        else
            return second;
    }
    
    public BoundedPair()
    {
        first = null;
        second = null;
    }

    public BoundedPair(T firstItem, T secondItem)
    {
        first = firstItem;
        second = secondItem;
    }

    public void setFirst(T newFirst)
    {
        first = newFirst;
    }

    public void setSecond(T newSecond)
    {
        second = newSecond;
    }

    public T getFirst()
    {
        return first;
    }

    public T getSecond()
    {
        return second;
    }

    public String toString()
    {
        return ( "first: " + first.toString() + "\n"
                + "second: " + second.toString() );
    }

    public boolean equals(Object otherObject)
    {
        if (otherObject == null)
            return false;
        else if (getClass( ) != otherObject.getClass( ))
            return false;
        else
        {
            BoundedPair<T> otherBoundedPair = (BoundedPair<T>)otherObject;
            return (first.equals(otherBoundedPair.first)
               && second.equals(otherBoundedPair.second));
        }
    }
}
