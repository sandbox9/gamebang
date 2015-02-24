(function(){
    "use strict";

    App.Router.map(function() {
        this.resource('theme', {path: "/theme"});
        this.resource('category', {path: "/category"});
        this.resource('season', {path: "/season"});
        this.resource('new', {path: "/new"});
        this.resource('product', {path: "/product/:productId"})
    });

    App.IndexRoute = Ember.Route.extend({
        redirect: function() {
            this.transitionTo('theme');
        }
    });

    App.ThemeRoute = Ember.Route.extend({
        model: function() {
            return Ember.$.getJSON('http://localhost:10001/catalog/theme');
        }
    });

    App.ProductRoute = Ember.Route.extend({
        model: function(params) {
            //return Ember.$.getJSON('http://localhost:10001/catalog/product/' + params.productId);
            var product = this.store.find('product', params.productId);
            console.log("product: " + product);
            return product;
        }
        ,setupController : function(controller, model){
            controller.set("model", model);
        }
    });

    App.ProductController = Ember.ObjectController.extend({
        actions: {
            addToCart: function(model) {
                console.log(">>submit model1: " + model);
                console.log("selected sku: " + model.get('selectedSku'));
                model.save();
            }
        },
        quantityWithOneToTen: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    });
})();