/* globals Donkey */


describe('Donkey', function ()
{
    'use strict';

    var donkey;

    beforeEach(function ()
    {
        donkey = new Donkey();
    });

    describe('when donkey gets hungry', function ()
    {
        beforeEach(function ()
        {
            donkey.makeHungry();
        });

        it('should ask for banana', function ()
        {
            expect(donkey.makeSound()).toEqual('banana');
        });

        describe('and when donkey gets banana', function ()
        {
            beforeEach(function ()
            {
                donkey.giveHay();
            });

            it('should go crazy again', function ()
            {
                expect(donkey.makeSound()).toBeUndefined();
            });
        });
    });
});