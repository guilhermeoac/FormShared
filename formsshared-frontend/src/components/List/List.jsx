import './List.css';
import React, { useRef, useEffect } from "react";

const List = ({children, scrollBottomFun}) => {
  const listInnerRef = useRef();

  const onScroll = () => {
    if (listInnerRef.current) {
      const { scrollTop, scrollHeight, clientHeight } = listInnerRef.current;
      const isNearBottom = scrollTop + clientHeight >= scrollHeight;

      if (isNearBottom) {
        console.log("Reached bottom");
        scrollBottomFun()
      }
    }
  };
  

  useEffect(() => {
    const listInnerElement = listInnerRef.current;

    if (listInnerElement) {
      listInnerElement.addEventListener("scroll", onScroll);

      // // Clean-up
      // return () => {
      //   listInnerElement.removeEventListener("scroll", onScroll);
      // };
    }
  }, []);

  return (
    <ul className="list" ref={listInnerRef}>
        {children}
    </ul>
  );
}

export default List;
