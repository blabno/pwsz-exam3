/* exported codecA */
function codecA(a, b) {

    'use strict';

    /* jshint bitwise: false */
    if (a & b) {
        return a + b;
    } else {
        return a;
    }
}

/* exported codecB */
function codecB(a, b) {

    'use strict';

    if (a && b) {
        return a + b;
    } else {
        return a + ',' + b;
    }
}

/* exported codecC */
function codecC(a, b) {

    /* jshint eqeqeq:false */
    'use strict';
    return a == b;
}

/* exported codecD */
function codecD(a, b) {

    'use strict';
    return a === b;
}