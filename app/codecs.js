/* exported codecA,codecB,codecC,codecD */
function codecA(a, b)
{
'use strict';
/*jshint bitwise: false*/
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
{
'use strict';
/*jshint eqeqeq: false*/
return a == b;
}
function codecD(a, b)
{
'use strict';
return a === b;
}
