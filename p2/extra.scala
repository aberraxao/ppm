/*
Exercise Extra:
There are methods in which it is more difficult to avoid multiple crossings of the list. Define a
polymorphic method (without using the List methods take or takeRight) that, given a list
and going through it only once, divides it into two (returning a pair of lists) with the same number
of elements (this, of course, if the original list has an even number of elements; in the other
case, one of the lists will have one more element).
Example:
divide(List(1,2,3,4)) // (List(1, 2),List(3, 4))
divide(List(1,2,3)) // (List(1, 2),List(3))
 */

def aux1[E]( l : List[E], len: Int) : (List[E], List[E]) =
{
  l match {
    case Nil => (Nil, Nil)
    case h :: t => {
      if(len != 0)
      {
        val v = aux1(t.init, len-1)
        (List(h) ++ v._1, v._2 ++ List(t.last))
      }
      else {
        if (!t.isEmpty)
          (List(h), List(t.last))
        else
          (List(h), List())
      }
    }
  }
}
def divide[E]( l : List[E]) : (List[E], List[E]) =
{
  val len = l.length / 2
  if(l.length % 2 == 0)
    aux1(l,len-1)
  else
    aux1(l,len)
}
// OR
def divide[E](lst: List[E]) : (List[E], List[E]) =
{
  lst match {
    case Nil => (Nil, Nil)
    case List(x) => (x::Nil, Nil)
    case x::xs => { val aux = divide(xs.init)
      (x::aux._1, aux._2++List(xs.last))
    }
  }
}