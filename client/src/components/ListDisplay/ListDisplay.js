import React, { PropTypes, Component } from 'react';
import withStyles from '../../decorators/withStyles';
import styles from './ListDisplay.css';

@withStyles(styles)
class ListDisplay extends Component {
  getInitialState() {
    return {
      username: '',
      lastGistUrl: ''
    };
  }

  componentDidMount() {
    $.get(this.props.source, function (result) {
      var lastGist = result[0];
      if (this.isMounted()) {
        this.setState({
          username: lastGist.owner.login,
          lastGistUrl: lastGist.html_url
        });
      }
    }.bind(this));
  };

  render() {
    return (
      <div className="ListDisplay">
        <p className="ListDisplay-input">This is the {this.props.maxLines}</p>
      </div>
    );
  }
}
export default ListDisplay;
