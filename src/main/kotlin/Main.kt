fun main(){
    val triangle = Triangle(Apex(3F,3F), Apex(5F, 3F), Apex(4F,6F))
    triangle.thirdApex = Apex(4F,3F)
    triangle.print()
    triangle.rotate(80)
    triangle.print()
    println(triangle.getPerimeter())
    println(triangle.getSquare())
}