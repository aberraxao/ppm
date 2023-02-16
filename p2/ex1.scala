/* 1a

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

/* 1b
scala> prod(List(1,2,3))
res5: Int = 6
*/

def prod(l:List[Int]):Int = l match {
	case List() => 1
	case x::xs => x * prod(xs)
	}

/* 1f
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
