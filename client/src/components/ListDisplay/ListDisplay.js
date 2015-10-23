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

  getInitialState() {
    return ({recipes: []});
  }

  componentDidMount() {
    client({method: 'GET', path: 'http://localhost:8080/actors/ask'}).done(response => {
      this.setState({recipes: response.entity._embedded.recipes});
    });
  }

  render() {
    return (
      <div className="ListDisplay">
        <p className="ListDisplay-input">{this.state.recipes}</p>
      </div>
    );
  }
}
export default ListDisplay;
