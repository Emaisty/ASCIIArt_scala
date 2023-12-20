package app.Helper

//helper _/(.-.)\_ Not much to say
class Helper {
    println("Program which accepts png, jpg or create random image and convert it into ascii art")
    println("Essential arguments. Should be at least one of each type:")
    println(":: input. Should be only one argument(!!!):")
    println(":::: --image <path_to_file> -- read from file")
    println(":::: --image-random -- generates random image by itself")
    println(":: output")
    println(":::: --output-console -- print in console")
    println(":::: --output-file <path_to_file> -- print into file. Creates text file")
    println()
    println()
    println("Table arguments. By default short one is chosen:")
    println(":: --table [full,short,non-linear] ")
    println(":: ----custom-table <users table>")
    println("Filters:")
    println(":: --invert -- invert grey scale from 0-255 to 255-0")
    println(":: --brightness <number> -- increase brightness by num/if num negative -- decrease brightness")
    println(":: --flip [x,y] -- flip image by x or y coordinates")

}
