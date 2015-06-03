/* exported codecA,codecB,codecC,codecD */
function codecA(a, b)
{
    /*jshint bitwise: false*/
    'use strict';
    if (a & b) {
        return a + b;
    } else {
        return a;
    }
}
function codecB(a, b)
{
    'use strict';
    if (a && b) {
        return a + b;
    } else {
        return a + ',' + b;
    }
}
function codecC(a, b)
{   /*jshint eqeqeq: false*/
    'use strict';
    return a == b;
}
function codecD(a, b)
{
    'use strict';
    return a === b;
}
