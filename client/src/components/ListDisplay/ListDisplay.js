import React, { PropTypes, Component } from 'react';
import withStyles from '../../decorators/withStyles';
import styles from './ListDisplay.css';

@withStyles(styles)
class ListDisplay extends Component {
  render() {
    return (
      <div className="ListDisplay">
        <p className="ListDisplay-input">This is the Control</p>
      </div>
    );
  }
}
export default ListDisplay;
