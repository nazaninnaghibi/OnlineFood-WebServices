
package servicepack;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the servicepack package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddFood_QNAME = new QName("http://servicepack/", "addFood");
    private final static QName _AddFoodResponse_QNAME = new QName("http://servicepack/", "addFoodResponse");
    private final static QName _AddUser_QNAME = new QName("http://servicepack/", "addUser");
    private final static QName _AddUserResponse_QNAME = new QName("http://servicepack/", "addUserResponse");
    private final static QName _DeleteFood_QNAME = new QName("http://servicepack/", "deleteFood");
    private final static QName _DeleteFoodResponse_QNAME = new QName("http://servicepack/", "deleteFoodResponse");
    private final static QName _GetAllOrderReformed_QNAME = new QName("http://servicepack/", "getAllOrderReformed");
    private final static QName _GetAllOrderReformedResponse_QNAME = new QName("http://servicepack/", "getAllOrderReformedResponse");
    private final static QName _GetAllOrders_QNAME = new QName("http://servicepack/", "getAllOrders");
    private final static QName _GetAllOrdersResponse_QNAME = new QName("http://servicepack/", "getAllOrdersResponse");
    private final static QName _GetFoodsHome_QNAME = new QName("http://servicepack/", "getFoodsHome");
    private final static QName _GetFoodsHomeResponse_QNAME = new QName("http://servicepack/", "getFoodsHomeResponse");
    private final static QName _GetOrder_QNAME = new QName("http://servicepack/", "getOrder");
    private final static QName _GetOrderReformed_QNAME = new QName("http://servicepack/", "getOrderReformed");
    private final static QName _GetOrderReformedResponse_QNAME = new QName("http://servicepack/", "getOrderReformedResponse");
    private final static QName _GetOrderResponse_QNAME = new QName("http://servicepack/", "getOrderResponse");
    private final static QName _GetTotalPrice_QNAME = new QName("http://servicepack/", "getTotalPrice");
    private final static QName _GetTotalPriceResponse_QNAME = new QName("http://servicepack/", "getTotalPriceResponse");
    private final static QName _SetAvaluable_QNAME = new QName("http://servicepack/", "setAvaluable");
    private final static QName _SetAvaluableResponse_QNAME = new QName("http://servicepack/", "setAvaluableResponse");
    private final static QName _SetOrder_QNAME = new QName("http://servicepack/", "setOrder");
    private final static QName _SetOrderDetail_QNAME = new QName("http://servicepack/", "setOrderDetail");
    private final static QName _SetOrderDetailResponse_QNAME = new QName("http://servicepack/", "setOrderDetailResponse");
    private final static QName _SetOrderResponse_QNAME = new QName("http://servicepack/", "setOrderResponse");
    private final static QName _SetReceived_QNAME = new QName("http://servicepack/", "setReceived");
    private final static QName _SetReceivedResponse_QNAME = new QName("http://servicepack/", "setReceivedResponse");
    private final static QName _SetSend_QNAME = new QName("http://servicepack/", "setSend");
    private final static QName _SetSendResponse_QNAME = new QName("http://servicepack/", "setSendResponse");
    private final static QName _Signin_QNAME = new QName("http://servicepack/", "signin");
    private final static QName _SigninResponse_QNAME = new QName("http://servicepack/", "signinResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: servicepack
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddFood }
     * 
     */
    public AddFood createAddFood() {
        return new AddFood();
    }

    /**
     * Create an instance of {@link AddFoodResponse }
     * 
     */
    public AddFoodResponse createAddFoodResponse() {
        return new AddFoodResponse();
    }

    /**
     * Create an instance of {@link AddUser }
     * 
     */
    public AddUser createAddUser() {
        return new AddUser();
    }

    /**
     * Create an instance of {@link AddUserResponse }
     * 
     */
    public AddUserResponse createAddUserResponse() {
        return new AddUserResponse();
    }

    /**
     * Create an instance of {@link DeleteFood }
     * 
     */
    public DeleteFood createDeleteFood() {
        return new DeleteFood();
    }

    /**
     * Create an instance of {@link DeleteFoodResponse }
     * 
     */
    public DeleteFoodResponse createDeleteFoodResponse() {
        return new DeleteFoodResponse();
    }

    /**
     * Create an instance of {@link GetAllOrderReformed }
     * 
     */
    public GetAllOrderReformed createGetAllOrderReformed() {
        return new GetAllOrderReformed();
    }

    /**
     * Create an instance of {@link GetAllOrderReformedResponse }
     * 
     */
    public GetAllOrderReformedResponse createGetAllOrderReformedResponse() {
        return new GetAllOrderReformedResponse();
    }

    /**
     * Create an instance of {@link GetAllOrders }
     * 
     */
    public GetAllOrders createGetAllOrders() {
        return new GetAllOrders();
    }

    /**
     * Create an instance of {@link GetAllOrdersResponse }
     * 
     */
    public GetAllOrdersResponse createGetAllOrdersResponse() {
        return new GetAllOrdersResponse();
    }

    /**
     * Create an instance of {@link GetFoodsHome }
     * 
     */
    public GetFoodsHome createGetFoodsHome() {
        return new GetFoodsHome();
    }

    /**
     * Create an instance of {@link GetFoodsHomeResponse }
     * 
     */
    public GetFoodsHomeResponse createGetFoodsHomeResponse() {
        return new GetFoodsHomeResponse();
    }

    /**
     * Create an instance of {@link GetOrder }
     * 
     */
    public GetOrder createGetOrder() {
        return new GetOrder();
    }

    /**
     * Create an instance of {@link GetOrderReformed }
     * 
     */
    public GetOrderReformed createGetOrderReformed() {
        return new GetOrderReformed();
    }

    /**
     * Create an instance of {@link GetOrderReformedResponse }
     * 
     */
    public GetOrderReformedResponse createGetOrderReformedResponse() {
        return new GetOrderReformedResponse();
    }

    /**
     * Create an instance of {@link GetOrderResponse }
     * 
     */
    public GetOrderResponse createGetOrderResponse() {
        return new GetOrderResponse();
    }

    /**
     * Create an instance of {@link GetTotalPrice }
     * 
     */
    public GetTotalPrice createGetTotalPrice() {
        return new GetTotalPrice();
    }

    /**
     * Create an instance of {@link GetTotalPriceResponse }
     * 
     */
    public GetTotalPriceResponse createGetTotalPriceResponse() {
        return new GetTotalPriceResponse();
    }

    /**
     * Create an instance of {@link SetAvaluable }
     * 
     */
    public SetAvaluable createSetAvaluable() {
        return new SetAvaluable();
    }

    /**
     * Create an instance of {@link SetAvaluableResponse }
     * 
     */
    public SetAvaluableResponse createSetAvaluableResponse() {
        return new SetAvaluableResponse();
    }

    /**
     * Create an instance of {@link SetOrder }
     * 
     */
    public SetOrder createSetOrder() {
        return new SetOrder();
    }

    /**
     * Create an instance of {@link SetOrderDetail }
     * 
     */
    public SetOrderDetail createSetOrderDetail() {
        return new SetOrderDetail();
    }

    /**
     * Create an instance of {@link SetOrderDetailResponse }
     * 
     */
    public SetOrderDetailResponse createSetOrderDetailResponse() {
        return new SetOrderDetailResponse();
    }

    /**
     * Create an instance of {@link SetOrderResponse }
     * 
     */
    public SetOrderResponse createSetOrderResponse() {
        return new SetOrderResponse();
    }

    /**
     * Create an instance of {@link SetReceived }
     * 
     */
    public SetReceived createSetReceived() {
        return new SetReceived();
    }

    /**
     * Create an instance of {@link SetReceivedResponse }
     * 
     */
    public SetReceivedResponse createSetReceivedResponse() {
        return new SetReceivedResponse();
    }

    /**
     * Create an instance of {@link SetSend }
     * 
     */
    public SetSend createSetSend() {
        return new SetSend();
    }

    /**
     * Create an instance of {@link SetSendResponse }
     * 
     */
    public SetSendResponse createSetSendResponse() {
        return new SetSendResponse();
    }

    /**
     * Create an instance of {@link Signin }
     * 
     */
    public Signin createSignin() {
        return new Signin();
    }

    /**
     * Create an instance of {@link SigninResponse }
     * 
     */
    public SigninResponse createSigninResponse() {
        return new SigninResponse();
    }

    /**
     * Create an instance of {@link OrderModel }
     * 
     */
    public OrderModel createOrderModel() {
        return new OrderModel();
    }

    /**
     * Create an instance of {@link CustomerModel }
     * 
     */
    public CustomerModel createCustomerModel() {
        return new CustomerModel();
    }

    /**
     * Create an instance of {@link FoodModel }
     * 
     */
    public FoodModel createFoodModel() {
        return new FoodModel();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddFood }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddFood }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicepack/", name = "addFood")
    public JAXBElement<AddFood> createAddFood(AddFood value) {
        return new JAXBElement<AddFood>(_AddFood_QNAME, AddFood.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddFoodResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddFoodResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicepack/", name = "addFoodResponse")
    public JAXBElement<AddFoodResponse> createAddFoodResponse(AddFoodResponse value) {
        return new JAXBElement<AddFoodResponse>(_AddFoodResponse_QNAME, AddFoodResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUser }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddUser }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicepack/", name = "addUser")
    public JAXBElement<AddUser> createAddUser(AddUser value) {
        return new JAXBElement<AddUser>(_AddUser_QNAME, AddUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUserResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddUserResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicepack/", name = "addUserResponse")
    public JAXBElement<AddUserResponse> createAddUserResponse(AddUserResponse value) {
        return new JAXBElement<AddUserResponse>(_AddUserResponse_QNAME, AddUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteFood }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteFood }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicepack/", name = "deleteFood")
    public JAXBElement<DeleteFood> createDeleteFood(DeleteFood value) {
        return new JAXBElement<DeleteFood>(_DeleteFood_QNAME, DeleteFood.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteFoodResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteFoodResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicepack/", name = "deleteFoodResponse")
    public JAXBElement<DeleteFoodResponse> createDeleteFoodResponse(DeleteFoodResponse value) {
        return new JAXBElement<DeleteFoodResponse>(_DeleteFoodResponse_QNAME, DeleteFoodResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllOrderReformed }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllOrderReformed }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicepack/", name = "getAllOrderReformed")
    public JAXBElement<GetAllOrderReformed> createGetAllOrderReformed(GetAllOrderReformed value) {
        return new JAXBElement<GetAllOrderReformed>(_GetAllOrderReformed_QNAME, GetAllOrderReformed.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllOrderReformedResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllOrderReformedResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicepack/", name = "getAllOrderReformedResponse")
    public JAXBElement<GetAllOrderReformedResponse> createGetAllOrderReformedResponse(GetAllOrderReformedResponse value) {
        return new JAXBElement<GetAllOrderReformedResponse>(_GetAllOrderReformedResponse_QNAME, GetAllOrderReformedResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllOrders }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllOrders }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicepack/", name = "getAllOrders")
    public JAXBElement<GetAllOrders> createGetAllOrders(GetAllOrders value) {
        return new JAXBElement<GetAllOrders>(_GetAllOrders_QNAME, GetAllOrders.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllOrdersResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllOrdersResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicepack/", name = "getAllOrdersResponse")
    public JAXBElement<GetAllOrdersResponse> createGetAllOrdersResponse(GetAllOrdersResponse value) {
        return new JAXBElement<GetAllOrdersResponse>(_GetAllOrdersResponse_QNAME, GetAllOrdersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFoodsHome }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetFoodsHome }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicepack/", name = "getFoodsHome")
    public JAXBElement<GetFoodsHome> createGetFoodsHome(GetFoodsHome value) {
        return new JAXBElement<GetFoodsHome>(_GetFoodsHome_QNAME, GetFoodsHome.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFoodsHomeResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetFoodsHomeResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicepack/", name = "getFoodsHomeResponse")
    public JAXBElement<GetFoodsHomeResponse> createGetFoodsHomeResponse(GetFoodsHomeResponse value) {
        return new JAXBElement<GetFoodsHomeResponse>(_GetFoodsHomeResponse_QNAME, GetFoodsHomeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrder }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetOrder }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicepack/", name = "getOrder")
    public JAXBElement<GetOrder> createGetOrder(GetOrder value) {
        return new JAXBElement<GetOrder>(_GetOrder_QNAME, GetOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrderReformed }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetOrderReformed }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicepack/", name = "getOrderReformed")
    public JAXBElement<GetOrderReformed> createGetOrderReformed(GetOrderReformed value) {
        return new JAXBElement<GetOrderReformed>(_GetOrderReformed_QNAME, GetOrderReformed.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrderReformedResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetOrderReformedResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicepack/", name = "getOrderReformedResponse")
    public JAXBElement<GetOrderReformedResponse> createGetOrderReformedResponse(GetOrderReformedResponse value) {
        return new JAXBElement<GetOrderReformedResponse>(_GetOrderReformedResponse_QNAME, GetOrderReformedResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrderResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetOrderResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicepack/", name = "getOrderResponse")
    public JAXBElement<GetOrderResponse> createGetOrderResponse(GetOrderResponse value) {
        return new JAXBElement<GetOrderResponse>(_GetOrderResponse_QNAME, GetOrderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTotalPrice }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetTotalPrice }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicepack/", name = "getTotalPrice")
    public JAXBElement<GetTotalPrice> createGetTotalPrice(GetTotalPrice value) {
        return new JAXBElement<GetTotalPrice>(_GetTotalPrice_QNAME, GetTotalPrice.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTotalPriceResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetTotalPriceResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicepack/", name = "getTotalPriceResponse")
    public JAXBElement<GetTotalPriceResponse> createGetTotalPriceResponse(GetTotalPriceResponse value) {
        return new JAXBElement<GetTotalPriceResponse>(_GetTotalPriceResponse_QNAME, GetTotalPriceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetAvaluable }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SetAvaluable }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicepack/", name = "setAvaluable")
    public JAXBElement<SetAvaluable> createSetAvaluable(SetAvaluable value) {
        return new JAXBElement<SetAvaluable>(_SetAvaluable_QNAME, SetAvaluable.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetAvaluableResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SetAvaluableResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicepack/", name = "setAvaluableResponse")
    public JAXBElement<SetAvaluableResponse> createSetAvaluableResponse(SetAvaluableResponse value) {
        return new JAXBElement<SetAvaluableResponse>(_SetAvaluableResponse_QNAME, SetAvaluableResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetOrder }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SetOrder }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicepack/", name = "setOrder")
    public JAXBElement<SetOrder> createSetOrder(SetOrder value) {
        return new JAXBElement<SetOrder>(_SetOrder_QNAME, SetOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetOrderDetail }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SetOrderDetail }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicepack/", name = "setOrderDetail")
    public JAXBElement<SetOrderDetail> createSetOrderDetail(SetOrderDetail value) {
        return new JAXBElement<SetOrderDetail>(_SetOrderDetail_QNAME, SetOrderDetail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetOrderDetailResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SetOrderDetailResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicepack/", name = "setOrderDetailResponse")
    public JAXBElement<SetOrderDetailResponse> createSetOrderDetailResponse(SetOrderDetailResponse value) {
        return new JAXBElement<SetOrderDetailResponse>(_SetOrderDetailResponse_QNAME, SetOrderDetailResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetOrderResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SetOrderResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicepack/", name = "setOrderResponse")
    public JAXBElement<SetOrderResponse> createSetOrderResponse(SetOrderResponse value) {
        return new JAXBElement<SetOrderResponse>(_SetOrderResponse_QNAME, SetOrderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetReceived }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SetReceived }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicepack/", name = "setReceived")
    public JAXBElement<SetReceived> createSetReceived(SetReceived value) {
        return new JAXBElement<SetReceived>(_SetReceived_QNAME, SetReceived.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetReceivedResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SetReceivedResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicepack/", name = "setReceivedResponse")
    public JAXBElement<SetReceivedResponse> createSetReceivedResponse(SetReceivedResponse value) {
        return new JAXBElement<SetReceivedResponse>(_SetReceivedResponse_QNAME, SetReceivedResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetSend }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SetSend }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicepack/", name = "setSend")
    public JAXBElement<SetSend> createSetSend(SetSend value) {
        return new JAXBElement<SetSend>(_SetSend_QNAME, SetSend.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetSendResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SetSendResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicepack/", name = "setSendResponse")
    public JAXBElement<SetSendResponse> createSetSendResponse(SetSendResponse value) {
        return new JAXBElement<SetSendResponse>(_SetSendResponse_QNAME, SetSendResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Signin }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Signin }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicepack/", name = "signin")
    public JAXBElement<Signin> createSignin(Signin value) {
        return new JAXBElement<Signin>(_Signin_QNAME, Signin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SigninResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SigninResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://servicepack/", name = "signinResponse")
    public JAXBElement<SigninResponse> createSigninResponse(SigninResponse value) {
        return new JAXBElement<SigninResponse>(_SigninResponse_QNAME, SigninResponse.class, null, value);
    }

}
