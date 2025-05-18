const ToDo = ({
    isComplete,
      value,
    onClick
  }) => {
    return (
      <div
        className="to-do"
        data-is-complete={isComplete}
        onClick={onClick}
      >
        <p>{value}</p>
      </div>
    )
  }
  
  export default ToDo;