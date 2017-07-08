from . import views
from django.conf.urls import url

urlpatterns = [
    url(r'^$', views.home_test),
    url(r'^sensors$', views.list_sensor, name="listsensor"),
    url(r'^addsensor$', views.add_sensor, name="addsensor"),
    url(r'^user$', views.list_user, name="listuser"),
    url(r'^adduser$', views.add_user, name="adduser"),
]
