import React, { Component } from 'react';
import CreateProjectButton from './projects/CreateProjectButton';
import ProjectItem from './projects/ProjectItem';

 class Dashboard extends Component {
  render() {
    return (<div class="projects">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="display-4 text-center">Projects</h1>
                    <br />
                    <CreateProjectButton/>
                    <br />
                    <hr />

                   <ProjectItem/>
                   <ProjectItem/>
                   

                </div>
            </div>
        </div>
    </div>);
  }
}
export default Dashboard;
