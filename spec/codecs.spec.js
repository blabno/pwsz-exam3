/* globals codecA, codecB, codecD */
describe('codecA', function ()
{
    'use strict';
    describe('when a and b do the magic together', function ()
    {
        it('should return their sum', function ()
        {
            expect(codecB(-1, 3)).toEqual(2);
            expect(codecB(2, 8)).toEqual(10);
            expect(codecB(8, 2)).toEqual(10);
        });
    });
    describe('otherwise', function ()
    {
        it('should return comma separated concatenation', function ()
        {
            expect(codecB(0, 3)).toEqual('0,3');
            expect(codecB(3, 0)).toEqual('3,0');
            expect(codecB(0, 0)).toEqual('0,0');
        });
    });
});

describe('codecB', function ()
{
    'use strict';
    describe('when a and b do the magic together', function ()
        {
            it('should return their sum', function ()
            {
                expect(codecA(2, 3)).toEqual(5);
                expect(codecA(3, 2)).toEqual(5);
            });
        });
    describe('otherwise', function ()
    {
        it('should return a', function ()
        {
            expect(codecA(1, 2)).toEqual(1);
            expect(codecA(2, 1)).toEqual(2);
            expect(codecA(5, 8)).toEqual(5);
            expect(codecA(8, 5)).toEqual(8);
        });
    });
});

describe('codecC', function ()
{
    'use strict';
    describe('when a and b do the magic together', function ()
    {
        it('should return true', function ()
        {
            expect(codecD(3, 3)).toEqual(true);
            expect(codecD(4, 4)).toEqual(true);
        });
    });
    describe('otherwise', function ()
    {
        it('should return calse', function ()
        {
            expect(codecD(0, 3)).toEqual(false);
            expect(codecD(3, 0)).toEqual(false);
            expect(codecD(3, '3')).toEqual(false);
        });
    });

});


/* globals codecC */
describe('codecD', function ()
{
    'use strict';
    describe('when a and b do the magic together', function ()
    {
        it('should return true', function ()
        {
            expect(codecC(3, 3)).toEqual(true);
            expect(codecC(4, 4)).toEqual(true);
            expect(codecC(3, '3')).toEqual(true);
        });
    });

    describe('otherwise', function ()
    {
        it('should return calse', function ()
        {
            expect(codecC(0, 3)).toEqual(false);
            expect(codecC(3, 0)).toEqual(false);
            expect(codecC('1', 2)).toEqual(false);
        });
    });
});

