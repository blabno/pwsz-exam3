/* exported codecA, codecB, codecC ,codecD */
function codecA(a, b)
{
    'use strict';
    if (a & b) {// jshint ignore:line
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
{
    'use strict';
    return a == b;// jshint ignore:line
}
function codecD(a, b)
{
    'use strict';
    return a === b;
}
