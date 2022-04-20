import kotlin.math.*

class Triangle {
    private var _firstApex:Apex = Apex(0F,0F)
    private var _secondApex:Apex = Apex(0F,0F)
    private var _thirdApex:Apex = Apex(0F,0F)

    constructor(firstApex: Apex, secondApex:Apex, thirdApex : Apex) {
        if(isСorrectTriangle(arrayOf(firstApex, secondApex, thirdApex))){
            _firstApex = firstApex;
            _secondApex = secondApex;
            _thirdApex = thirdApex;
        } else {
            println("Ошибка инициализации треугольника: неверные координаты")
        }
    }

    var firstApex
        set(value){
            if(isСorrectTriangle(arrayOf (value, secondApex, thirdApex))){
                _firstApex = value
            } else {
                println("Неверные координаты вершины 1: x = ${value.x}, y = ${value.y}")
            }
        }
        get() = _firstApex

    var secondApex
        set(value){
            if(isСorrectTriangle(arrayOf (firstApex, value, thirdApex))){
                _secondApex = value
            } else {
                println("Неверные координаты вершины 2: x = ${value.x}, y = ${value.y}")
            }
        }
        get() = _secondApex

    var thirdApex
        set(value){
            if(isСorrectTriangle(arrayOf (firstApex, secondApex, value))){
                _thirdApex = value
            } else {
                println("Неверные координаты вершины 3: x = ${value.x}, y = ${value.y}")
            }
        }
        get() = _thirdApex

    fun print(){
        println("Координаты треугольника: ");
        println("x1: ${firstApex.x}, y1: ${firstApex.y}");
        println("x2: ${secondApex.x}, y2: ${secondApex.y}");
        println("x3: ${thirdApex.x}, y3: ${thirdApex.y}");
    }

    fun getSquare():Float {
        val left = (firstApex.x - thirdApex.x) * (secondApex.y - thirdApex.y)
        val right = (secondApex.x - thirdApex.x) * (firstApex.y - thirdApex.y)
        var square:Float = 0.5F * (left - right);

        if(square < 0){
            square *= -1
        }

        return square;
    }

    fun getPerimeter():Float{
        val fSide = sqrt((secondApex.x - firstApex.x).pow(2) + (secondApex.y - firstApex.y).pow(2))
        val sSide = sqrt((thirdApex.x - secondApex.x).pow(2) + (thirdApex.y - secondApex.y).pow(2))
        val tSide = sqrt((thirdApex.x - firstApex.x).pow(2) + (thirdApex.y - firstApex.y).pow(2))

        return fSide + sSide + tSide
    }

    fun rotate(angle:Int){
        val center:Apex = Apex((firstApex.x + secondApex.x + thirdApex.x)/3,
            (firstApex.y + secondApex.y + thirdApex.y)/3)

        val rad:Double = angle * PI / 180

        rotateApex(center, firstApex, rad)
        rotateApex(center, secondApex, rad)
        rotateApex(center, thirdApex, rad)
    }

    private fun rotateApex(center:Apex, apex:Apex, rad:Double){
        val x:Float = apex.x;
        apex.x = ((x - center.x) * cos(rad) - (apex.y - center.y) * sin(rad) + center.x).toFloat()
        apex.y = ((x - center.x) * sin(rad) + (apex.y - center.y) * cos(rad) + center.y).toFloat()
    }

    private fun isСorrectTriangle(arrayOfApex:Array<Apex>):Boolean{
        val firstVector = arrayOfApex[1] - arrayOfApex[0]
        val secondVector = arrayOfApex[2] - arrayOfApex[1]

        if(firstVector.x == 0F && firstVector.y == 0F || secondVector.x == 0F && secondVector.y == 0F){
            return false;
        }

        val n:Float = if(firstVector.x != 0F) {
            secondVector.x / firstVector.x
        } else {
            secondVector.y / firstVector.y
        }

        if(firstVector.x * n == secondVector.x && firstVector.y * n == secondVector.y){
            return false;
        }

        return true;
    }
}