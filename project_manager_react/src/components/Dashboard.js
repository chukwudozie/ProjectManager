import React, { Component } from 'react';
import ProjectItem from './projects/ProjectItem';

 class Dashboard extends Component {
  render() {
    return (<div>
     This is the Dashboard.
     <ProjectItem/> 
    </div>);
  }
}
export default Dashboard;
