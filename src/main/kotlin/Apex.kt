class Apex(var x:Float, var y:Float){
    operator fun minus(apex: Apex) : Apex{
        return Apex (x - apex.x, y - apex.y)
    }
}