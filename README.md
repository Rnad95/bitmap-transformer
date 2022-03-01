# Bitmap Transformer

## BitMap Class

The BitMap class is created to transform the image.

- There are three function in this class:

1. invert : which multiply each pixel in the picture. It takes the output path and created a new image.

to choose this transform you should be write in CLI `invert`

> ./gradlew run --args 'input output `invert`'

2. Mirror Function which reflect the image Vertically.

- To choose this transform you should be write in CLI `mirrorImage`

> ./gradlew run --args 'input output `mirrorimage`'

3. Black and white which convert all the color inside the image to gray-scale level.

> > ./gradlew run --args 'input output `blackandwhite`'
