/**    
 *  Asmsupport is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
/**
 * 
 */
package cn.wensiqun.asmsupport.core.definition.variable;


import cn.wensiqun.asmsupport.core.block.KernelProgramBlock;
import cn.wensiqun.asmsupport.core.operator.AbstractOperator;
import cn.wensiqun.asmsupport.org.objectweb.asm.Opcodes;
import cn.wensiqun.asmsupport.standard.def.clazz.IClass;
import cn.wensiqun.asmsupport.standard.def.var.meta.Field;
import cn.wensiqun.asmsupport.standard.def.var.meta.VarMeta;
import cn.wensiqun.asmsupport.utils.ASConstants;


/**
 * Represent a {@code super} keyword variable.
 * 
 * @author wensiqun at 163.com(Joe Wen)
 */
public class SuperVariable extends ImplicitVariable{

    private Field globalVariableMeta;
    
    public SuperVariable(IClass aclass) {
        this.globalVariableMeta = new Field(
        		aclass.getSuperclass(), 
        		aclass.getSuperclass(), 
        		aclass.getSuperclass(), 
                Opcodes.ACC_FINAL, ASConstants.SUPER);
    }

    @Override
    public void loadToStack(KernelProgramBlock block) {
        block.getInstructionHelper().loadThis();
    }

    @Override
    public boolean availableFor(AbstractOperator operator) {
        return true;
    }


    @Override
    public IClass getResultType() {
        return globalVariableMeta.getType();
    }

    @Override
    public VarMeta getMeta() {
        return globalVariableMeta;
    }
   
}
