Categories.Router.map(function(){
    //this.resource('todos', { path: '/' });
    this.resource('categories', { path: '/'});
});

Categories.CategoriesRoute = Ember.Route.extend({
    model: function() {
        //return this.store.find('todo');
        return this.store.find('mainCategory');
    }
});