// 1a) Create a Scala file (Fun.scala) with the following code
//singleton object
object Fun {
def func1(x : Double, y :Int) = x + (70*y)
def ex(a: Double) = 50 * a

/*
2 a) Define a method that receives two pairs of integers and returns a pair of integers. The
first element of the result being the sum of the first input pair, and the second element
of the result pair the product of the second input pair.
Fun.func2a((2,4), (4,8))
*/
def func2a(a:(Int, Int), b:(Int, Int)): (Int, Int) = {
	(a._1 + a._2, b._1 * b._2)
}

/*
2b) Write a method that, given three Int numbers, returns a pair containing the largest
element in the first element, and the second largest number in the second element.
*/
def maior(x:Int, y:Int): Int = {
	if(x>y) x else y
}

def menor(x:Int, y:Int): Int = {
	if(x<y) x else y
}

def maiorDe3(a:Int, b:Int, c:Int): Int = {
	maior(maior(a,b),c)
}

/*
acho os 2 maiores, depois vou ver qual deles é o menor
 
scala> Fun.middle3(1,2,2)
res8: Int = 2

scala> Fun.middle3(1,2,8)
res9: Int = 2

scala> Fun.middle3(3,7,2)
res10: Int = 3
*/
def middle3(a:Int, b:Int, c:Int): Int = {
	(menor (maior(a,b), maior(menor(a,b),c)))
}

/*
2c) Write a method that receives a triple of Int numbers and returns a triple where the same
numbers are ordered in descending order.
scala> Fun.sort3(12,4,8)
res13: (Int, Int, Int) = (12,8,4)

scala> Fun.sort3(12,8,4)
res14: (Int, Int, Int) = (12,8,4)

scala> Fun.sort3(1,8,4)
res15: (Int, Int, Int) = (8,4,1)

*/

def menorDe3(a:Int, b:Int, c:Int): Int = {
	menor(menor(a,b),c)
}

def sort3(a:Int, b:Int, c:Int): (Int, Int, Int) = {
	(maiorDe3(a,b,c), middle3(a,b,c), menorDe3(a,b,c))
}

/*
2d)
The sides of any triangle respect the following constraint: the sum of the lengths of any
two sides, is greater than the length of the third side. Write a method that receive the
length of three segments and return a Boolean value indicating whether the constraint
is satisfied.

scala> Fun.isTriangle(1,2,3)
res0: Boolean = false

scala> Fun.isTriangle(2,5,4)
res2: Boolean = true

scala> Fun.isTriangle(4,4,4)
res3: Boolean = true
*/
def isTriangle(a:Double, b:Double, c:Double): Boolean = {
	((a+b>c) && (a+c>b) && (b+c>a)) 
}

/*
2e)
Write a method abrev that receives a string containing a person's name and returns a
string with the first and last name.
For example, abrev "José Carlos Martins Sousa" = "José Sousa"
*/
def abrev(a:Double, b:Double, c:Double): Boolean = {
	((a+b>c) && (a+c>b) && (b+c>a)) 
}

}
