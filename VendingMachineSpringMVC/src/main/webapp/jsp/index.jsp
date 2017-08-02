<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Vending Machine</title>
        <!--BOOTstrap code CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
              rel="stylesheet">
        <style>
            h4 {
                text-align:center;
                margin-top:10px;
                padding-top:0px;
            }
            #button1:hover,#button2:hover,#button3:hover,#button4:hover,#button5:hover,#button6:hover,#button7:hover,#button8:hover,#button9:hover{
                box-shadow:10px 10px 10px;
            }

        </style>

    </head>
    <body>
        <div class="container">
            <h1 class="text-center" id="one">Vending Machine</h1>
            <hr/>

            <div class="col-lg-9" style="float:left;">
                <c:forEach var="currentItem" items="${itemList}">
                    <div class="col-lg-4" style="height:270px;" id="div${currentItem.id}">
                        <form action="selectItem" method="POST" style="height:90%;width:100%;">
                            <input type="hidden"
                                   class="form-control"
                                   name="itemID"
                                   value="${currentItem.id}"
                                   readonly/>
                            <button value="" style="border:2px solid black;height:100%;width:100%;background-color:white;" type="submit" id="button${currentItem.id}">
                                <p style="margin-top:-40px;font-size:125%;" id="item" class="text-left">${currentItem.id}</p>
                                <h4 id="" style="margin-bottom:30px;">${currentItem.itemName}</h4>
                                <h4 id = "" style="margin-bottom:70px;">$${currentItem.itemPrice}</h4>
                                <h4 id="">Quantity left: ${currentItem.itemQuantity}</h4>
                            </button>

                        </form>
                    </div>
                </c:forEach>
            </div>


            <div class="col-lg-3" style="">
                <div class="col-lg-12" style="height:270px;">
                    <div class="text-center">
                        <h2 style="margin-top:0px;">Total $ In</h2>
                        <form id="totalIn">
                            <input  type="text"
                                    class="form-control"
                                    id="total-in"
                                    style="width:150px;margin: 10px auto 20px;border:1px solid black"
                                    value="${amount}"
                                    placeholder="0.00" readonly/>
                        </form>
                        <form  action="addDollar" method="POST" style="display:inline;">
                            <button type="sumbit"
                                    class="btn btn-default"
                                    style="width:100px;"
                                    name="dollar" style="margin:5px auto;">Add Dollar
                            </button>
                        </form>
                        <form action="addQuarter" method="POST" style="display:inline;">
                            <button type="submit"
                                    class="btn btn-default"
                                    style="width:100px;"
                                    id="add-quarter" style="margin:5px auto;">Add Quarter
                            </button>
                        </form>
                    </div>
                    <div class="text-center">
                        <form action="addDime" method="POST" style="display:inline;">
                            <button type="submit"
                                    class="btn btn-default"
                                    style="width:100px;"
                                    id="add-dime" style="margin:5px auto;">Add Dime
                            </button>
                        </form>
                        <form action="addNickel" method="POST" style="display:inline;">
                            <button type="submit"
                                    class="btn btn-default"
                                    style="width:100px;"
                                    id="add-nickel" style="margin:5px auto;">Add Nickel
                            </button>
                        </form>
                    </div>
                </div>

                <div class="col-lg-12" style="height:270px;">
                    <hr style="height:1px;background-color:black;margin-top:0px;margin-bottom:5px;"/>
                    <form id="message">
                        <h2 class="text-center" style="margin-top:0px;">Messages</h2>
                        <input  type="text"
                                class="form-control"
                                value="${message}"
                                style="width:200px;height:40px;margin: 10px auto;border:1px solid black" readonly/>
                    </form>
                    <h3 style="display:inline;margin-left:20px;">Item: </h3>
                    <form id="itemBox" style="display:inline;">
                        <input  value="${item.itemName}"
                                type="text"
                                class="form-control"
                                id="item-box"
                                style="width:140px;margin: 10px auto;border:1px solid black;display:inline;"
                                placeholder="" readonly/>
                    </form>
                    <form action="vend" method="POST" >
                        <button type="submit"
                                class="btn btn-default"
                                style="width:200px;margin:20px auto 0px;display:block;"
                                id="make-purchase">Make Purchase</button></form>

                </div>

                <div class="col-lg-12" style="height:270px;">
                    <hr style="height:1px;background-color:black;margin-top:0px;margin-bottom:5px;"/>
                    <h2 class="text-center" style="margin-top:0px;">Change</h2>

                    <input  value="${change}"
                            type="text"
                            class="form-control"
                            id="change"
                            style="height:40px;width:200px;margin: 10px auto;border:1px solid black;" readonly/>

                    <form action="returnChange" method="POST">
                        <button type="submit"
                                class="btn btn-default"
                                style="width:175px;margin:20px auto 0px;display:block;"
                                id="change-return">Change Return</button>
                    </form>
                </div>
            </div>

        </div>


        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>

