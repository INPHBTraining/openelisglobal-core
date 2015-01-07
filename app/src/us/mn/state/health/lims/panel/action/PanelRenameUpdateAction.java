/**
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * 
* Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for
 * the specific language governing rights and limitations under the License.
 * 
* The Original Code is OpenELIS code.
 * 
* Copyright (C) INPHB. All Rights Reserved.
 */
package us.mn.state.health.lims.panel.action;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import us.mn.state.health.lims.common.action.BaseAction;
import us.mn.state.health.lims.common.services.DisplayListService;
import us.mn.state.health.lims.hibernate.HibernateUtil;
import us.mn.state.health.lims.localization.daoimpl.LocalizationDAOImpl;
import us.mn.state.health.lims.panel.dao.PanelDAO;
import us.mn.state.health.lims.panel.daoimpl.PanelDAOImpl;
import us.mn.state.health.lims.panel.valueholder.Panel;

public class PanelRenameUpdateAction extends BaseAction {

    @Override
    protected ActionForward performAction(ActionMapping mapping,
            ActionForm form, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        //The number of panels is pretty short so we don't have to worry about efficancy
        //Get the list of panels from the session (ActionForm)
        //Iterate through them one by one
        //If the new name is not the same as the name gotten from the database then
        //save it
        //Names should be compared using panel.getPanelName() and updated with panel.setPanelName()
        PanelDAO panelDAO = new PanelDAOImpl();
        List<Panel> updatableList = new ArrayList<>();

        //This is where the new code should go
        Transaction tx = HibernateUtil.getSession().beginTransaction();

        try {
            for (Panel panel : updatableList) {
                panel.setSysUserId(currentUserId);
                panelDAO.updateData(panel);
            }
            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
        } finally {
            HibernateUtil.closeSession();
        }

        DisplayListService.refreshList(DisplayListService.ListType.PANELS);
        
        return mapping.findForward(FWD_SUCCESS);
    }

    @Override
    protected String getPageTitleKey() {
        return "panel.add.title";

    }

    @Override
    protected String getPageSubtitleKey() {
        return "panel.edit.title";

    }

}
