import React, { PropTypes, Component } from 'react';
import withStyles from '../../decorators/withStyles';
import styles from './ListDisplay.css';

@withStyles(styles)
class ListDisplay extends Component {
  static propTypes = {
    maxLines: PropTypes.number,
  };

  static defaultProps = {
    maxLines: 1,
  };

  render() {
    return (
      <div className="ListDisplay">
        <p className="ListDisplay-input">This is the List</p>
      </div>
    );
  }
}
export default ListDisplay;
