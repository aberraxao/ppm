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
	case (x::y::ys) => y::x::transf(ys)
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

def prod(l:List[Int]):Int = l match {
	case List() => 1
	case x::xs => x * prod(xs)
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

/*
1c)
Define a method that, given a list and an element, places it at the end of the list.
TODO
*/
def transf[A](l:List[A], e:A):List[A] = l match {
	case Nil => List[A]; case List(x) => List(x)
	case (x::y::ys) => y::x::transf(ys)
}


/*
1e)
Define a sumEl recursive method that receives a list of pairs of Int and calculates the
sum of the pairs with indexes 2 and 4.
Example: sumEl(List((1,2),(3,4),(2,0),(5,6),(1,1)) // 2+0+1+1

scala> sumEl(List((1,2),(3,4),(2,0),(5,6),(1,1)))
res11: Int = 4
*/

def sumEl(l:List[(Int,Int)]) = {
	def aux(l1:List[(Int,Int)], count:Int, acc:Int):Int = l1 match {
		case Nil => acc
		case (x::xs) => if(count == 2 || count == 4) aux(xs, count+1, acc+x._1+x._2)
						else aux(xs, count+1, acc)
	}
	aux(l, 0, 0)
}

// ou

def sumEl(l:List[(Int,Int)]) = {
	def aux(l1:List[(Int,Int)], count:Int, acc:Int):Int = l1 match {
		case Nil => acc
		case ((a,b)::xs) => if(count == 2 || count == 4) aux(xs, count+1, acc+a+b)
						else aux(xs, count+1, acc)
	}
	aux(l, 0, 0)
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

// ou

def metH(l:List[Double], d:Double):(List[Double], List[Double]) = l match {
	case Nil => (Nil, Nil)
	case (x::xs) => if(x<d) {val res = metH(xs,d); (x::res._1, res._2)}
					else    {val res = metH(xs,d); (res._1, x::res._2)}
}