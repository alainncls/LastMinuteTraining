package fr.epf.lastminutetraining.paypal;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.epf.lastminutetraining.domain.Transaction;

@Controller
public class Checkout {

	@RequestMapping(method = RequestMethod.GET, value = { "/cart/checkout" })
	protected ModelAndView get(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		// Use "request" to read incoming HTTP headers (e.g. cookies)
		// and HTML form data (e.g. data the user entered and submitted)

		// Use "response" to specify the HTTP response line and headers
		// (e.g. specifying the content type, setting cookies).

		/*
		 * The paymentAmount is the total value of ' the purchase. ' ' : Enter
		 * the total Payment Amount within the quotes. ' example : paymentAmount
		 * = "15.00";
		 */
		String paymentAmount = Float.toString(((Transaction) session.getAttribute("Cart")).getTotal());

		/*
		 * '------------------------------------ ' The returnURL is the location
		 * where buyers return to when a ' payment has been succesfully
		 * authorized. ' ' This is set to the value entered on the Integration
		 * Assistant '------------------------------------
		 */

		String returnURL = "http://lastminutetraining.epf.fr:8080/orderConfirmation";

		/*
		 * '------------------------------------ ' The cancelURL is the location
		 * buyers are sent to when they hit the ' cancel button during
		 * authorization of payment during the PayPal flow ' ' This is set to
		 * the value entered on the Integration Assistant
		 * '------------------------------------
		 */
		String cancelURL = "http://localhost:8080/404";

		/*
		 * '------------------------------------ ' The items hashmap contains
		 * the details of each item '------------------------------------ :
		 * change "item name" to desired item name
		 */

		Map item = new HashMap();
		item.put("name", "item name");
		item.put("amt", paymentAmount);
		item.put("qty", "1");

		/*
		 * '------------------------------------ ' Calls the SetExpressCheckout
		 * API call ' ' The SetExpressCheckout function is defined in the file
		 * PayPalFunctions.java,
		 * '-------------------------------------------------
		 */
		PaypalFunctions ppf = new PaypalFunctions();
		HashMap nvp = ppf.setExpressCheckout(paymentAmount, returnURL,
				cancelURL, item);// System.out.println(item);
		String strAck = nvp.get("ACK").toString();
		if (strAck != null && strAck.equalsIgnoreCase("Success")) {

			// ' Redirect to paypal.com
			String redirectURL = "redirect:https://www.sandbox.paypal.com/cgi-bin/webscr?cmd=_express-checkout&token="
					+ nvp.get("TOKEN").toString();

			return new ModelAndView(redirectURL);
		} else {
			// Display a user friendly Error on the page using any of the
			// following error information returned by PayPal

			String ErrorCode = nvp.get("L_ERRORCODE0").toString();
			String ErrorShortMsg = nvp.get("L_SHORTMESSAGE0").toString();
			String ErrorLongMsg = nvp.get("L_LONGMESSAGE0").toString();
			String ErrorSeverityCode = nvp.get("L_SEVERITYCODE0").toString();

			return new ModelAndView("/404");
		}

	}

	@RequestMapping(method = RequestMethod.POST, value = { "/cart/checkout" })
	protected ModelAndView post(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		return get(request, response, session);
	}

}