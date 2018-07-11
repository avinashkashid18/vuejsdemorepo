<%@ include file="/init.jsp" %>
   <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700,400italic|Material+Icons">
    <link rel="stylesheet" href="https://unpkg.com/vue-material@beta/dist/vue-material.min.css">
    <link rel="stylesheet" href="https://unpkg.com/vue-material@beta/dist/theme/default.css">
<div id="<portlet:namespace />">

<div class="page-container">
















    <md-app>
      <md-app-toolbar class="md-primary" md-elevation="0">
        <md-button class="md-icon-button" @click="toggleMenu" v-if="!menuVisible">
          <md-icon>menu</md-icon>
        </md-button>
        <span class="md-title">My Title</span>
      </md-app-toolbar>

      <md-app-drawer :md-active.sync="menuVisible" md-persistent="mini">
        <md-toolbar class="md-transparent" md-elevation="0">
          <span>Navigation</span>

          <div class="md-toolbar-section-end">
            <md-button class="md-icon-button md-dense" @click="toggleMenu">
              <md-icon>keyboard_arrow_left</md-icon>
            </md-button>
          </div>
        </md-toolbar>

        <md-list>
          <md-list-item>
            <md-icon>move_to_inbox</md-icon>
            <span class="md-list-item-text">Inbox</span>
          </md-list-item>

          <md-list-item>
            <md-icon>send</md-icon>
            <span class="md-list-item-text">Sent Mail</span>
          </md-list-item>

          <md-list-item>
            <md-icon>delete</md-icon>
            <span class="md-list-item-text">Trash</span>
          </md-list-item>

          <md-list-item>
            <md-icon>error</md-icon>
            <span class="md-list-item-text">Spam</span>
          </md-list-item>
        </md-list>
      </md-app-drawer>

      <md-app-content>
        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Error quibusdam, non molestias et! Earum magnam, similique, quo recusandae placeat dicta asperiores modi sint ea.
        
  <div>
    <md-field>
      <md-icon>event</md-icon>
      <label>Date</label>
      <md-input v-model="date"></md-input>
    </md-field>

    <md-field>
      <label>Voice</label>
      <md-input v-model="voice"></md-input>
      <md-icon>keyboard_voice</md-icon>
    </md-field>

    <md-field>
      <label>Description</label>
      <md-textarea v-model="description"></md-textarea>
      <md-icon>description</md-icon>
    </md-field>

    <md-field>
      <md-icon class="md-accent">warning</md-icon>
      <label>Transfer Money</label>
      <md-input v-model="money"></md-input>
      <md-icon>attach_money</md-icon>
    </md-field>
  </div>

        
        
        
        <div>
    <md-table v-model="searched" md-sort="name" md-sort-order="asc" md-card md-fixed-header>
      <md-table-toolbar>
        <div class="md-toolbar-section-start">
          <h1 class="md-title">Users</h1>
        </div>

        <md-field md-clearable class="md-toolbar-section-end">
          <md-input placeholder="Search by name..." v-model="search" @input="searchOnTable" />
        </md-field>
      </md-table-toolbar>

      <md-table-empty-state
        md-label="No users found"
        :md-description="`No user found for this '${search}' query. Try a different search term or create a new user.`">
        <md-button class="md-primary md-raised" @click="newUser">Create New User</md-button>
      </md-table-empty-state>

      <md-table-row slot="md-table-row" v-for="item in searched" slot-scope="{ item }">
        <md-table-cell md-label="ID" md-sort-by="id" md-numeric>{{ item.id }}</md-table-cell>
        <md-table-cell md-label="Name" md-sort-by="name">{{ item.name }}</md-table-cell>
        <md-table-cell md-label="Email" md-sort-by="email">{{ item.email }}</md-table-cell>
        <md-table-cell md-label="Gender" md-sort-by="gender">{{ item.gender }}</md-table-cell>
        <md-table-cell md-label="Job Title" md-sort-by="title">{{ item.title }}</md-table-cell>
         <md-table-cell md-label="Job Title" md-sort-by="title">{{ item.title }}</md-table-cell>
      </md-table-row>
    </md-table>
  </div>
        
      </md-app-content>
    </md-app>
  </div>




 
  
  
<!--   <table-component
     :data="[
     { firstName: 'John', birthday: '04/10/1940', songs: 72 },
     { firstName: 'Paul', birthday: '18/06/1942', songs: 70 },
     { firstName: 'George', birthday: '25/02/1943', songs: 22 },
     { firstName: 'Ringo', birthday: '07/07/1940', songs: 2 },
     ]"
     sort-by="songs"
     sort-order="asc"
     >
     <table-column show="firstName" label="First name"></table-column>
     <table-column show="songs" label="Songs" data-type="numeric"></table-column>
     <table-column show="birthday" label="Birthday" :filterable="false" data-type="date:DD/MM/YYYY"></table-column>
 </table-component>
  
   -->
  
 <!--  <foldable  height="100">
  As for the separation of logic vs template within module is something Im still a bit confused by. Of course in VUE I have seen the same idea, having everything put to single component file (be it a template, logic or styling of that component) - one file to rule em all ... but stillAs for the separation of logic vs template within module is something Im still a bit confused by. Of course in VUE I have seen the same idea, having everything put to single component file (be it a template, logic or styling of that component) - one file to rule em all ... but stillAs for the separation of logic vs template within module is something Im still a bit confused by. Of course in VUE I have seen the same idea, having everything put to single component file (be it a template, logic or styling of that component) - one file to rule em all ... but still
 
</foldable>
   -->
</div>

<aui:script require="vue-demo@1.0.0">
	vueDemo100.call('<portlet:namespace />');
</aui:script>