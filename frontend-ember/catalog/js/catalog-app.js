(function(){
    "use strict";

    window.App = Ember.Application.create();

    /* model + REST 일 때 prefix 주기 위해 사용 */
    App.ApplicationAdapter = DS.RESTAdapter.extend({
        host: 'http://localhost:10001',
        namespace: 'catalog'
    });
})();