window.App = Ember.Application.create();

App.Router.map(function() {
    this.resource('theme', {path: "/theme"});
    this.resource('category', {path: "/category"});
    this.resource('season', {path: "/season"});
    this.resource('new', {path: "/new"});
    this.resource('productDetail', {path: "/productDetail/:productId"})
});

App.IndexRoute = Ember.Route.extend({
    redirect: function() {
        this.transitionTo('theme');
    }
});

App.ThemeRoute = Ember.Route.extend({
    model: function() {
        return [
            {
                productId: 'P101',
                productName: '레고1',
                productPrice: 1000
            },
            {
                productId: 'P102',
                productName: '레고2',
                productPrice: 2000
            },
            {
                productId: 'P103',
                productName: '레고3',
                productPrice: 3000
            }
        ];
    }
});

App.ProductDetailRoute = Ember.Route.extend({
    model: function(params) {
        return {
            productId: params.productId,
            productName: '레고1',
            productPrice: 1000
        };
    }
});