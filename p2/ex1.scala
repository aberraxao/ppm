/* 1a)
Define the method transf that does the following transformation: receives a list and
replaces the 1st with the 2nd element, and the 3rd with the 4th, until the end of the list.
For example: transf [1,2,3,4,5,6] ⇒ [2,1,4,3,6,5].

scala> transf(List(1,2,3))
res1: List[Int] = List(2, 1, 3)

scala> transf(List(1,2,3,4))
res2: List[Int] = List(2, 1, 4, 3)

scala> transf(List(1,2,3,4,5))
res3: List[Int] = List(2, 1, 4, 3, 5)
*/

def transf(l:List[Int]):List[Int] = l match {
	case Nil => Nil; case List(x) => List(x)
	case x::y::ys => y::x::transf(ys)
}

// scala> transf(List("1","2","3","4","5"))
// res4: List[String] = List(2, 1, 4, 3, 5)

def transf[A](l:List[A]):List[A] = l match {
	case Nil => Nil; case List(x) => List(x)
	case (x::y::ys) => y::x::transf(ys)
}

/* 1b)
Define a method that calculates the product of all the elements in a list of numbers.

scala> prod(List(1,2,3))
res5: Int = 6
*/

def product(l:List[Int]):Int = l match {
	case List() => 1
	case x::xs => x * product(xs)
	}

/* 1c)
Define a method that, given a list and an element, places it at the end of the list.

scala> end(List(1,2,3),5)
res9: List[Int] = List(1, 2, 3, 5)
*/
def end(lst:List[Int], e: Int): List[Int] =
{
	lst match{
		case Nil => List(e)
		case h :: Nil => h :: List(e)
		case x => x ++ List(e)
	}
}

// OR
def end1(lst: List[Int], e: Int): List[Int] =
{
	lst match {
		case Nil => List(e)
		case _ => lst ++ List(e)
	}
}
/* 1d)
Define a method that, given two lists (of any type) concatenates them (without using
the ++ operator), i.e., creates a list with the elements of the first list followed by those
on the second list.

scala> concat1(List(1,2,3),List(4,5,6))
res2: List[Int] = List(1, 2, 3, 4, 5, 6)
*/
def concat1[E](lst1:List[E], lst2:List[E]): List[E] =
{
	lst1 match {
		case List() => lst2
		case h::t => h::concat1(t,lst2)
	}
}
// OR
def concat[E](lst1:List[E], lst2:List[E]): List[E] = { lst1 ++ lst2}

/* 1e)
Define a sumEl recursive method that receives a list of pairs of Int and calculates the
sum of the pairs with indexes 2 and 4.
Example: sumEl(List((1,2),(3,4),(2,0),(5,6),(1,1)) // 2+0+1+1

scala> sumEl(List((1,2),(3,4),(2,0),(5,6),(1,1)))
res4: Int = 4
*/
def aux1(xs: List[(Int, Int)], count: Int, acc: Int): Int =
{xs match {
	case Nil => acc
	case h :: t => {
		if(count == 2 || count == 4)
			aux1(t, count+1, acc + h._1 + h._2)
		else
			aux1(t, count+1, acc)
	}
}
}
def sumEl(xs: List[(Int, Int)]): Int = { aux1(xs, 0, 0)}

// OR

def sumEl(l: List[(Int, Int)]) = {
	def aux(l1: List[(Int, Int)], count: Int, acc: Int): Int = l1 match {
		case Nil => acc
		case (x :: xs) => if (count == 2 || count == 4) aux(xs, count + 1, acc + x._1 + x._2)
		else aux(xs, count + 1, acc)
	}

	aux(l, 0, 0)
}

// OR

def sumEl(l: List[(Int, Int)]) = {
	def aux(l1: List[(Int, Int)], count: Int, acc: Int): Int = l1 match {
		case Nil => acc
		case ((a, b) :: xs) => if (count == 2 || count == 4) aux(xs, count + 1, acc + a + b)
		else aux(xs, count + 1, acc)
	}

	aux(l, 0, 0)
}

/* 1f)
In the previous work sheet, we have seen a way to calculate the average of a list of
numbers.
def average1(lst: List[Double]) = lst.sum / lst.length
However, this solution goes through the list two times!
i.
ii.
Define a method that given a list, calculates a pair containing the length of the
list and the sum of its elements – going through the list only once.
Using the previous method, define a method that calculates the average of the
elements of a list.

scala> average(List(1,2,3))
res6: Double = 2.0
*/
def average(l:List[Double]):Double = {
	def aux(l1:List[Double]):(Int, Double) = l1 match {
		case Nil => (0,0)
		case (x::xs) => { val (size, sum) = aux(xs)
							(size+1, sum+x)
						}
		}
		val res = aux(l)
		res._2 / res._1
	}

/* 1g)
Define a method that, given a list (of Double) and a value (Double), returns a pair of lists
where the first contains all the elements of the list below this value and the second list
contains all other elements.
Example: metH(List(1.0,2.0,4.0,5.0), 3.0) //(List(1.0, 2.0), List(4.0, 5.0))

scala> metH(List(1,2,3,4),2)
res13: (List[Double], List[Double]) = (List(1.0),List(2.0, 3.0, 4.0))
*/

def metH(l:List[Double], d:Double):(List[Double], List[Double]) = l match {
	case Nil => (Nil, Nil)
	case (x::xs) => if(x<d) (x::metH(xs,d)._1, metH(xs,d)._2) 
					else    (metH(xs,d)._1, x::metH(xs,d)._2) 
}

// OR

def metH(l:List[Double], d:Double):(List[Double], List[Double]) = l match {
	case Nil => (Nil, Nil)
	case (x::xs) => if(x<d) {val res = metH(xs,d); (x::res._1, res._2)}
					else    {val res = metH(xs,d); (res._1, x::res._2)}
}

/* 1h)
Define a method that, given a list of Double, returns the list with the elements that are
superior or equal to the average.

scala> divByAverage(List(1,2,3,4))
res14: List[Double] = List(3.0, 4.0)
*/

def divByAverage(l : List[Double]) : List[Double] =
{
	val av = average(l)
	val res = metH(l, av)
	res._2
}
