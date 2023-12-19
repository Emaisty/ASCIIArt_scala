# ASCII Art

for arguments run:

```scala
run --help
```
## Structure

**2 main parts:**
- app - UI, how input going to be processed (right now only by CLI) and controller, which parse argument input and create convertor
- Ascii convertor:
- - Front - loader. Load/Crete image
- - Middle:
- - - Convertor - from image in RGB to grey
- - - Filter - applies (if user said so) filters on greyscale image
- - - Table Convertor - from greyscale image to ascii art
- - Back - print ascii art

