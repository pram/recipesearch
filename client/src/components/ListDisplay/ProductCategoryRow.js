import React, { PropTypes, Component } from 'react';
import withStyles from '../../decorators/withStyles';
import styles from './ListDisplay.css';

@withStyles(styles)
class ProductCategoryRow extends Component {
  render() {
    return (<tr><th colSpan="2">{this.props.category}</th></tr>);
  }
}

export default ProductCategoryRow;
