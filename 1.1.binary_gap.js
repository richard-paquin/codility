// you can write to stdout for debugging purposes, e.g.
// console.log('this is a debug message');

function solution(N) {
    // write your code in JavaScript (Node.js 4.0.0)
    while((N & ~1) === N) { // 0
        N = N >> 1;
    }
    var count = 0;
    var maxCount = 0;
    while(N > 0) {
        if ((N & ~1) === N) { // 0
            // console.log(0);
            count += 1;
            if (count > maxCount) {
                maxCount = count;
            }
        } else { // 1
            // console.log(1);
            count = 0;
        }
        N = N >> 1;
    }
    return maxCount;
}
